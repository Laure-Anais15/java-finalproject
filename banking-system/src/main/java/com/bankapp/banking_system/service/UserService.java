package com.bankapp.banking_system.service;

import com.bankapp.banking_system.model.users.AccountHolder;
import com.bankapp.banking_system.model.users.User;
import com.bankapp.banking_system.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    // Récupérer tous les utilisateurs
    public List<AccountHolder> getAllUsers() {
        return accountHolderRepository.findAll();
    }

    // Récupérer un utilisateur par ID
    public Optional<AccountHolder> getUserById(Long id) {
        return accountHolderRepository.findById(id);
    }

    // Créer un nouvel utilisateur
    public AccountHolder createUser(AccountHolder user) {
        return accountHolderRepository.save(user);
    }

    // Supprimer un utilisateur
    public void deleteUser(Long id) {
        accountHolderRepository.deleteById(id);
    }

}
