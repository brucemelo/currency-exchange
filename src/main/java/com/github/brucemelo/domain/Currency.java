package com.github.brucemelo.domain;


import jakarta.persistence.Embeddable;

/**
 *  The "Currency Code" field is the ISO 4217 Three Letter Currency Code.
 *  AUD, BRL, USD
 */
@Embeddable
public record Currency(String code) {

    public static final int THREE_LETTER_CODE = 3;

}
