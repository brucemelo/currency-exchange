package com.github.brucemelo.web;

import com.github.brucemelo.domain.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface Model {

    record CurrencyPair(@NotBlank @Size(min = Currency.THREE_LETTER_CODE, max = Currency.THREE_LETTER_CODE)
                        String from,
                        @NotBlank @Size(min = Currency.THREE_LETTER_CODE, max = Currency.THREE_LETTER_CODE)
                        String to) {}

}
