package com.bankapp.banking_system.service;

import com.bankapp.banking_system.model.accounts.Account;
import com.bankapp.banking_system.model.embedded.Money;
import com.bankapp.banking_system.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than 0.");
        }

        // Charger les comptes (ils seront soit CheckingAccount, soit SavingAccount...)
        var fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        var toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("Recipient account not found"));

        // Vérification solde
        if (fromAccount.getBalance().getAmount().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds on sender account");
        }

        // Modification des soldes
        fromAccount.getBalance().setAmount(fromAccount.getBalance().getAmount().subtract(amount));
        toAccount.getBalance().setAmount(toAccount.getBalance().getAmount().add(amount));

        // Sauvegarde
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}

