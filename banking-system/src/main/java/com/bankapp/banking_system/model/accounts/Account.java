package com.bankapp.banking_system.model.accounts;

import com.bankapp.banking_system.model.users.AccountHolder;
import com.bankapp.banking_system.model.embedded.Money;
import com.bankapp.banking_system.enums.Status;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
public abstract class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Account() {
    }

    @Embedded
    private Money balance;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "penalty_fee")),
            @AttributeOverride(name = "currency", column = @Column(name = "penalty_currency"))
    })
    private Money penaltyFee = new Money(new BigDecimal("40.00")); // fixe pour tous les comptes

    @ManyToOne
    @JoinColumn(name = "primary_owner_id", nullable = false)
    private AccountHolder primaryOwner;

    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolder secondaryOwner;

    private LocalDate creationDate;

    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDate.now();
    }

    //current state of the account - new accounts initialized as active by default
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

}
