package com.bankapp.banking_system.service;

import com.bankapp.banking_system.model.accounts.Account;
import com.bankapp.banking_system.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAccount() {
        Account account = new Account();
        account.setBalance(new BigDecimal("100.00"));

        when(accountRepository.save(account)).thenReturn(account);
/*
        Account result = accountService.createAccount(account);

        assertNotNull(result);
        assertEquals(new BigDecimal("100.00"), result.getBalance());
        verify(accountRepository, times(1)).save(account);
        */
    }

    @Test
    void testGetAllAccounts() {
        Account a1 = new Account();
        a1.setBalance(new BigDecimal("100.00"));
        Account a2 = new Account();
        a2.setBalance(new BigDecimal("250.00"));

        List<Account> accounts = Arrays.asList(a1, a2);

        when(accountRepository.findAll()).thenReturn(accounts);

        List<Account> result = accountService.getAllAccounts();

        assertEquals(2, result.size());
        assertEquals(new BigDecimal("100.00"), result.get(0).getBalance());
        assertEquals(new BigDecimal("250.00"), result.get(1).getBalance());
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    void testGetAccountById() {
        /*
        Account account = new Account();
        account.setId(1L);
        account.setBalance(new BigDecimal("300.00"));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        Account result = accountService.getAccountById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(new BigDecimal("300.00"), result.getBalance());
        verify(accountRepository, times(1)).findById(1L);

 */
    }

    @Test
    void testUpdateAccount() {
        Account existing = new Account();
        existing.setId(1L);
        existing.setBalance(new BigDecimal("100.00"));

        Account updated = new Account();
        updated.setBalance(new BigDecimal("500.00"));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(accountRepository.save(any(Account.class))).thenReturn(existing);

        Account result = accountService.updateAccount(1L, updated);

        assertEquals(new BigDecimal("500.00"), result.getBalance());
        verify(accountRepository, times(1)).findById(1L);
        verify(accountRepository, times(1)).save(existing);
    }

    @Test
    void testDeleteAccount() {
        Long accountId = 1L;

        doNothing().when(accountRepository).deleteById(accountId);

        accountService.deleteAccount(accountId);

        verify(accountRepository, times(1)).deleteById(accountId);
    }
}
