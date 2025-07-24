package com.bankapp.banking_system.service;

import com.bankapp.banking_system.model.users.User;
import com.bankapp.banking_system.model.accounts.Account;
import com.bankapp.banking_system.repository.UserRepository;
import com.bankapp.banking_system.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {

    private AdminService adminService;
    private UserRepository userRepository;
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        accountRepository = Mockito.mock(AccountRepository.class);
        adminService = new AdminService(userRepository, accountRepository);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        User user1 = new User(); user1.setId(1L);
        User user2 = new User(); user2.setId(2L);
        List<User> mockUsers = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(mockUsers);

        // Act
        List<User> users = adminService.getAllUsers();

        // Assert
        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testDeleteUser_Success() {
        // Arrange
        Long userId = 1L;
        when(userRepository.existsById(userId)).thenReturn(true);

        // Act
        adminService.deleteUser(userId);

        // Assert
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testDeleteUser_NotFound() {
        // Arrange
        Long userId = 999L;
        when(userRepository.existsById(userId)).thenReturn(false);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> adminService.deleteUser(userId));
        verify(userRepository, never()).deleteById(userId);
    }

    @Test
    void testGetAllAccounts() {
        // Arrange
        Account account1 = new Account(); account1.setId(1L);
        Account account2 = new Account(); account2.setId(2L);
        List<Account> mockAccounts = Arrays.asList(account1, account2);

        when(accountRepository.findAll()).thenReturn(mockAccounts);

        // Act
        List<Account> accounts = adminService.getAllAccounts();

        // Assert
        assertEquals(2, accounts.size());
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    void testDeleteAccount_Success() {
        // Arrange
        Long accountId = 1L;
        when(accountRepository.existsById(accountId)).thenReturn(true);

        // Act
        adminService.deleteAccount(accountId);

        // Assert
        verify(accountRepository, times(1)).deleteById(accountId);
    }

    @Test
    void testDeleteAccount_NotFound() {
        // Arrange
        Long accountId = 999L;
        when(accountRepository.existsById(accountId)).thenReturn(false);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> adminService.deleteAccount(accountId));
        verify(accountRepository, never()).deleteById(accountId);
    }
}
