package com.bankapp.banking_system.model.accounts;

import jakarta.persistence.*;
import lombok.*;
import com.bankapp.banking_system.model.embedded.Money;

import java.math.BigDecimal;

@Entity // Représente une table dans la BDD
@Getter // Génère automatiquement les getters
@Setter // Génère automatiquement les setters
@NoArgsConstructor // Génère un constructeur vide (obligatoire pour JPA)
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

//rajouter une @Table pour préciser le nom de la table? @Table(name = "checking")