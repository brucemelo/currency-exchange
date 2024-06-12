package com.github.brucemelo.service;

import com.github.brucemelo.domain.Currency;
import com.github.brucemelo.domain.CurrencyPair;
import com.github.brucemelo.domain.ExchangeRate;
import com.github.brucemelo.domain.ExchangeRateRepository;
import com.github.brucemelo.integration.ExchangeRateClient;
import io.quarkus.narayana.jta.QuarkusTransaction;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.OffsetDateTime;
import java.util.Map;

@Singleton
public class ExchangeRateService {

    @ConfigProperty(name = "app.exchange-rate-api.apikey")
    String apiKey;

    @RestClient
    ExchangeRateClient exchangeRateClient;

    @Inject
    ExchangeRateRepository exchangeRateRepository;

    public ExchangeRate exchange(String fromCurrency, String toCurrency) {
        var result = exchangeRateClient.exchangeRate(apiKey, fromCurrency);
        var conversionRate = result.conversionRates().entrySet()
                .stream()
                .filter(value -> value.getKey().equals(toCurrency))
                        .map(Map.Entry::getValue).findFirst().orElseThrow(ConversionRateNotFound::new);
        return QuarkusTransaction.joiningExisting().call(() -> {
            var entity = new ExchangeRate();
            entity.date = OffsetDateTime.now();
            entity.currencyPair = new CurrencyPair(new Currency(fromCurrency), new Currency(toCurrency));
            entity.conversionRate = conversionRate;
            exchangeRateRepository.persist(entity);
            return entity;
        });
    }

}
