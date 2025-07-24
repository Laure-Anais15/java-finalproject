package com.bankapp.banking_system.model.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ThirdParty extends User {

    @Column(nullable = false)
    private String hashedKey;

    public ThirdParty(String name, String username, String password, String hashedKey) {
        super(null, name, username, password);
        this.hashedKey = hashedKey;
    }
}

