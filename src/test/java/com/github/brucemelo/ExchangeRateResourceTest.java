package com.github.brucemelo;

import com.github.brucemelo.domain.ExchangeRate;
import com.github.brucemelo.web.Model;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class ExchangeRateResourceTest {

    @Test
    void testExchangeRate() {
        var result = given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Model.CurrencyPair("USD", "BRL"))
                .when().post("/exchange-rate")
                .then()
                .statusCode(201)
                .extract().body().as(ExchangeRate.class);

        Assertions.assertNotNull(result.conversionRate);
        Assertions.assertNotNull(result.date);
        Assertions.assertNotNull(result.currencyPair);
        Assertions.assertNotNull(result.id);
    }

    @Test
    void testExceptionExchangeRate() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Model.CurrencyPair("USDX", "BRL"))
                .when().post("/exchange-rate")
                .then()
                .statusCode(400);
    }

    @Test
    void testExceptionBlankExchangeRate() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Model.CurrencyPair("", "BRL"))
                .when().post("/exchange-rate")
                .then()
                .statusCode(400);
    }

    @Test
    void testExceptionNullExchangeRate() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Model.CurrencyPair(null, "BRL"))
                .when().post("/exchange-rate")
                .then()
                .statusCode(400);
    }

}