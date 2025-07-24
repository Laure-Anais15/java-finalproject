package com.bankapp.banking_system.controller;

import com.bankapp.banking_system.model.accounts.Account;
import com.bankapp.banking_system.model.accounts.Checking;
import com.bankapp.banking_system.model.accounts.Savings;
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
    public Checking createAccount(@RequestBody Checking account) {
        return accountService.createCheckingAccount(account);
    }

    @PostMapping("/saving")
    public Savings createAccount(@RequestBody Savings account) {
        return accountService.createSavingsAccount(account);
    }

    // Endpoint PUT /accounts/{id}
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    // Endpoint DELETE /accounts/{id}
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
