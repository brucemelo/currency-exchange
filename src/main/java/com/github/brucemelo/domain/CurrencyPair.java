package com.github.brucemelo.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record CurrencyPair(
        @AttributeOverride(name = "code", column = @Column(name = "fromCurrency", length = Currency.THREE_LETTER_CODE))
        Currency from,
        @AttributeOverride(name = "code", column = @Column(name = "toCurrency", length = Currency.THREE_LETTER_CODE))
        Currency to) {
}
