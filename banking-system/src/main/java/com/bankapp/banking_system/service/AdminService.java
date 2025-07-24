package com.bankapp.banking_system.service;

import com.bankapp.banking_system.model.users.User;
import com.bankapp.banking_system.model.accounts.Account;
import com.bankapp.banking_system.repository.AccountRepository;
import com.bankapp.banking_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    // Consulter tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Supprimer un utilisateur
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(userId);
    }

    // Consulter tous les comptes
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Supprimer un compte
    public void deleteAccount(Long accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new RuntimeException("Account not found");
        }
        accountRepository.deleteById(accountId);
    }
}
