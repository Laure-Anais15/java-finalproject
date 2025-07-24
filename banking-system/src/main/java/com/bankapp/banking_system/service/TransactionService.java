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

    // Transactionnelle = si erreur, on annule tout
    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than 0.");
        }

        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("Recipient account not found"));
/*
        if (fromAccount.getBalance().getAmount() < amount) {
            throw new RuntimeException("Insufficient funds on sender account");
        }

        // Débit et crédit
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        // Sauvegarde
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        */
    }
}
