package com.bankapp.banking_system.model.accounts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CreditCard extends Account {

    @Column(name = "credit_limit", precision = 10, scale = 2)
    private BigDecimal creditLimit = new BigDecimal("100.00");

    @Column(name = "interest_rate", precision = 5, scale = 4)
    private BigDecimal interestRate = new BigDecimal("0.2");

    public void setCreditLimit(BigDecimal creditLimit) {
        if (creditLimit.compareTo(new BigDecimal("100000.00")) > 0) {
            throw new IllegalArgumentException("Credit limit cannot exceed 100000");
        }
        this.creditLimit = creditLimit;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(new BigDecimal("0.1")) < 0) {
            throw new IllegalArgumentException("Interest rate must be >= 0.1");
        }
        this.interestRate = interestRate;
    }
}
