package com.bankapp.banking_system.model.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.math.BigDecimal;
import java.util.Currency;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Money {

    private BigDecimal amount;
    private Currency currency = Currency.getInstance("EUR");

    public Money(BigDecimal amount) {
        this.amount = amount;
        this.currency = Currency.getInstance("EUR");
    }
}
