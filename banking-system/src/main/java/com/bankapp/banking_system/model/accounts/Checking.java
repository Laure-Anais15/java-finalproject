package com.bankapp.banking_system.model.accounts;

import jakarta.persistence.*;
import lombok.*;
import com.bankapp.banking_system.model.embedded.Money;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Checking extends Account {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })
    private Money minimumBalance = new Money(new BigDecimal("250.00"));
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "monthly_maintenance_fee")),
            @AttributeOverride(name = "currency", column = @Column(name = "monthly_maintenance_currency"))
    })
    private Money monthlyMaintenanceFee = new Money(new BigDecimal("12.00"));

    @Column(name = "secret_key")
    private String secretKey;
}
