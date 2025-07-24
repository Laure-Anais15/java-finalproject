package com.bankapp.banking_system.config;

import com.bankapp.banking_system.enums.Status;
import com.bankapp.banking_system.model.accounts.Checking;
import com.bankapp.banking_system.model.embedded.Money;
import com.bankapp.banking_system.model.users.AccountHolder;
import com.bankapp.banking_system.model.embedded.Address;
import com.bankapp.banking_system.repository.AccountRepository;
import com.bankapp.banking_system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(UserRepository userRepository, AccountRepository accountRepository) {
        return args -> {
            // Créer une adresse
            Address address = new Address("10 rue de Paris", "Paris", "France", "75000");

            // Créer un utilisateur AccountHolder
            AccountHolder user = new AccountHolder();
            user.setName("Alice Dupont");
            user.setUsername("alice");
            user.setPassword("password");
            user.setDateOfBirth(LocalDate.of(1990, 5, 12));
            user.setPrimaryAddress(address);

            userRepository.save(user);

            // Créer un compte Checking pour cet utilisateur
            Checking checking = new Checking();
            checking.setBalance(new Money(new BigDecimal("1500.00")));
            checking.setPrimaryOwner(user);
            checking.setSecretKey("mySecret123");
            checking.setStatus(Status.ACTIVE);

            accountRepository.save(checking);

            System.out.println("✅ Données de test insérées avec succès !");
        };
    }
}
