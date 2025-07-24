package com.bankapp.banking_system.controller;

import com.bankapp.banking_system.model.users.User;
import com.bankapp.banking_system.model.accounts.Account;
import com.bankapp.banking_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // GET /admin/users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    // DELETE /admin/users/{id}
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return "User deleted successfully";
    }

    // GET /admin/accounts
    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return adminService.getAllAccounts();
    }

    // DELETE /admin/accounts/{id}
    @DeleteMapping("/accounts/{id}")
    public String deleteAccount(@PathVariable Long id) {
        adminService.deleteAccount(id);
        return "Account deleted successfully";
    }
}
