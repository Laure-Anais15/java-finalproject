package com.bankapp.banking_system.model.accounts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentChecking extends Account {

    @Column(name = "secret_key")
    private String secretKey;
}
