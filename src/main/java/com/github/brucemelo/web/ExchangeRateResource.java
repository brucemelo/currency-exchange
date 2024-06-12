package com.github.brucemelo.web;

import com.github.brucemelo.domain.ExchangeRateRepository;
import com.github.brucemelo.service.ExchangeRateService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;


@Path("/exchange-rate")
public class ExchangeRateResource {

    @Inject
    ExchangeRateService exchangeRateService;

    @Inject
    ExchangeRateRepository exchangeRateRepository;

    @POST
    public Response exchangeRate(@Valid Model.CurrencyPair currencyPair) {
        var result = exchangeRateService.exchange(currencyPair.from(), currencyPair.to());
        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    @GET
    public Response list() {
        return Response.ok(exchangeRateRepository.listAll()).build();
    }

}
