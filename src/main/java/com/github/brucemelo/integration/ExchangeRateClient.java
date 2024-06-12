package com.github.brucemelo.integration;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "exchange-rate-api")
public interface ExchangeRateClient {

    @GET
    @Path("/{apikey}/latest/{currency}")
    ExchangeRateApi exchangeRate(@PathParam("apikey") String apikey, @PathParam("currency") String currency);

}
