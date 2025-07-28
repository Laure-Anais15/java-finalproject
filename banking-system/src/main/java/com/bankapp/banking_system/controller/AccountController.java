package com.bankapp.banking_system.controller;

import com.bankapp.banking_system.model.accounts.*;
import com.bankapp.banking_system.model.embedded.Money;
import com.bankapp.banking_system.model.users.AccountHolder;
import com.bankapp.banking_system.service.AccountService;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Endpoint GET /accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Endpoint GET /accounts/{id}
    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // Endpoint POST /accounts
    @PostMapping("/checking")
    public Checking createCheckingAccount(@RequestBody Checking account) {
        return accountService.createCheckingAccount(account);
    }

    @PostMapping("/savings")
    public Savings createSavingsAccount(@RequestBody Savings account) {
        return accountService.createSavingsAccount(account);
    }

    @PostMapping("/creditcard")
    public CreditCard createCreditCardAccount(@RequestBody CreditCard account) {
        return accountService.createCreditCardAccount(account);
    }

    @PostMapping("/studentchecking")
    public StudentChecking createStudentCheckingAccount(@RequestBody StudentChecking account) {
        return accountService.createStudentCheckingAccount(account);
    }

    // Endpoint PUT /accounts/{id}
    @PutMapping("/{id}/balance")
    public Account updateAccountBalance(@PathVariable Long id, @RequestBody Money newBalance) {
        return accountService.updateAccountBalance(id, newBalance);
    }


    // Endpoint DELETE /accounts/{id}
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
