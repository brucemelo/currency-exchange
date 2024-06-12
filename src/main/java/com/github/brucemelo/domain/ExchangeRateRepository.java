package com.github.brucemelo.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExchangeRateRepository implements PanacheRepository<ExchangeRate> {

}
