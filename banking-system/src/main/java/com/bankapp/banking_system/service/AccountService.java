package com.bankapp.banking_system.service;
import com.bankapp.banking_system.model.accounts.Account;
import com.bankapp.banking_system.model.accounts.Checking;
import com.bankapp.banking_system.model.accounts.Savings;
import com.bankapp.banking_system.model.users.AccountHolder;
import com.bankapp.banking_system.repository.AccountHolderRepository;
import com.bankapp.banking_system.repository.AccountRepository;
import com.bankapp.banking_system.repository.CheckingAccountRepository;
import com.bankapp.banking_system.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private CheckingAccountRepository checkingAccountRepository;
    @Autowired
    private SavingsRepository savingsAccountRepository;

    // Récupérer tous les comptes
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Récupérer un compte par son ID
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    // Créer un nouveau compte
    public Account createAccount(Account account) {
        return checkingAccountRepository.save((Checking) account);
    }

    public Checking createCheckingAccount(Checking account){
        return checkingAccountRepository.save(account);
    }



    public Savings createSavingsAccount(Savings account) {
        return savingsAccountRepository.save(account);
    }

    // Supprimer un compte
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    // Mettre à jour un compte
    public Account updateAccount(Long id, Account updatedAccount) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account existing = optionalAccount.get();
            existing.setBalance(updatedAccount.getBalance());
            existing.setPrimaryOwner(updatedAccount.getPrimaryOwner());
            // Ajoute ici d’autres champs si nécessaire
            return accountRepository.save(existing);
        } else {
            throw new RuntimeException("Account not found with id: " + id);
        }
    }
}
