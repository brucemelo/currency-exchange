package com.github.brucemelo.integration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

public record ExchangeRateApi(@JsonProperty("conversion_rates") Map<String, BigDecimal> conversionRates) {
}
