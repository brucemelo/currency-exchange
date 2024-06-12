package com.github.brucemelo.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Entity
public class ExchangeRate extends PanacheEntity {

    public OffsetDateTime date;
    @Column(scale = 4, precision = 5)
    public BigDecimal conversionRate;
    @Embedded
    public CurrencyPair currencyPair;

}
