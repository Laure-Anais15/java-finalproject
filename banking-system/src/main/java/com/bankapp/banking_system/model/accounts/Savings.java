package com.bankapp.banking_system.model.accounts;

import com.bankapp.banking_system.model.embedded.Money;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Savings extends Account {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })
    private Money minimumBalance = new Money(new BigDecimal("1000.00"));

    @Column(name = "interest_rate", precision = 10, scale = 4)
    private BigDecimal interestRate = new BigDecimal("0.0025");

    public void setMinimumBalance(Money minimumBalance) {
        if (minimumBalance.getAmount().compareTo(new BigDecimal("100.00")) < 0) {
            throw new IllegalArgumentException("Minimum balance cannot be lower than 100");
        }
        this.minimumBalance = minimumBalance;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(new BigDecimal("0.5")) > 0) {
            throw new IllegalArgumentException("Interest rate cannot be higher than 0.5");
        }
        this.interestRate = interestRate;
    }

    @Column(name = "secret_key")
    private String secretKey;

    /*constructeur a rajouter pour imposer les regles des la création?

    public Savings(Money balance, AccountHolder primaryOwner, String secretKey) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;

        // Valeurs par défaut si rien n'est fourni
        this.minimumBalance = new Money(new BigDecimal("1000"));
        this.interestRate = new BigDecimal("0.0025");
    }

2e constructeur avec vérification

public Savings(Money balance, AccountHolder primaryOwner, String secretKey, Money minimumBalance, BigDecimal interestRate) {
    super(balance, primaryOwner);
    this.secretKey = secretKey;

    if (minimumBalance.getAmount().compareTo(new BigDecimal("100")) < 0) {
        throw new IllegalArgumentException("Minimum balance cannot be below 100.");
    }
    if (interestRate.compareTo(new BigDecimal("0.5")) > 0) {
        throw new IllegalArgumentException("Interest rate cannot exceed 0.5.");
    }

    this.minimumBalance = minimumBalance;
    this.interestRate = interestRate;
}     */
}
