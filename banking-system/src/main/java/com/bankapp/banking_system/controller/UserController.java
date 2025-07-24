package com.bankapp.banking_system.controller;

import com.bankapp.banking_system.model.users.AccountHolder;
import com.bankapp.banking_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint GET /users
    @GetMapping
    public List<AccountHolder> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint GET /users/{id}
    @GetMapping("/{id}")
    public Optional<AccountHolder> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Endpoint POST /users
    @PostMapping
    public AccountHolder createUser(@RequestBody AccountHolder user) {
        return userService.createUser(user);
    }

    // Endpoint DELETE /users/{id}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
