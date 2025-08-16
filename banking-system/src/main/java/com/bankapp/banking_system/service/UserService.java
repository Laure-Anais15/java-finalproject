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

    public List<AccountHolder> getAllUsers() {
        return accountHolderRepository.findAll();
    }

    public Optional<AccountHolder> getUserById(Long id) {
        return accountHolderRepository.findById(id);
    }

    public AccountHolder createUser(AccountHolder user) {
        return accountHolderRepository.save(user);
    }

    public void deleteUser(Long id) {
        accountHolderRepository.deleteById(id);
    }

}
