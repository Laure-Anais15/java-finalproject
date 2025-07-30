package com.bankapp.banking_system.service;
import com.bankapp.banking_system.model.accounts.*;
import com.bankapp.banking_system.model.embedded.Money;
import com.bankapp.banking_system.model.users.AccountHolder;
import com.bankapp.banking_system.repository.AccountHolderRepository;
import com.bankapp.banking_system.repository.AccountRepository;
import com.bankapp.banking_system.repository.CheckingAccountRepository;
import com.bankapp.banking_system.repository.SavingsRepository;
import com.bankapp.banking_system.repository.CreditCardRepository;
import com.bankapp.banking_system.repository.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private CheckingAccountRepository checkingAccountRepository;
    @Autowired
    private SavingsRepository savingsAccountRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    // Récupérer tous les comptes
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Récupérer un compte par son ID
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    // Créer un nouveau compte
    public Checking createCheckingAccount(Checking account){
        return checkingAccountRepository.save(account);
    }

    public Savings createSavingsAccount(Savings account) {
        return savingsAccountRepository.save(account);
    }

    public CreditCard createCreditCardAccount(CreditCard account) {
        return creditCardRepository.save(account);
    }

    public StudentChecking createStudentCheckingAccount(StudentChecking account) {
        return studentCheckingRepository.save(account);
    }

    // Supprimer un compte
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public Account updateAccountBalance(Long accountId, Money newBalance) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    public AccountHolder updateAccountHolderMail(Long accountId, String newName) {
        AccountHolder account = accountHolderRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));
        account.setName(newName);
        return accountHolderRepository.save(account);
    }
}
