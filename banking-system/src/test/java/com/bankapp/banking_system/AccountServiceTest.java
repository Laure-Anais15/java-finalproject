package com.bankapp.banking_system.service;

import com.bankapp.banking_system.model.accounts.Account;
import com.bankapp.banking_system.model.embedded.Money;
import com.bankapp.banking_system.repository.AccountRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
        account.setId(1L);
        account.setBalance(new Money(new BigDecimal("500.00"), Currency.getInstance("USD")));
    }

    @Test
    void testUpdateAccountBalance_success() {
        // GIVEN
        Money newBalance = new Money(new BigDecimal("1000.00"), Currency.getInstance("USD"));

        Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
        Mockito.when(accountRepository.save(any(Account.class))).thenAnswer(i -> i.getArgument(0));

        // WHEN
        Account updatedAccount = accountService.updateAccountBalance(1L, newBalance);

        // THEN
        assertEquals(newBalance, updatedAccount.getBalance());
        verify(accountRepository).findById(1L);
        verify(accountRepository).save(account);
    }

    @Test
    void testUpdateAccountBalance_accountNotFound() {
        // GIVEN
        Money newBalance = new Money(new BigDecimal("1000.00"), Currency.getInstance("USD"));

        Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.empty());

        // THEN
        assertThrows(RuntimeException.class, () -> {
            // WHEN
            accountService.updateAccountBalance(1L, newBalance);
        });

        verify(accountRepository).findById(1L);
        verify(accountRepository, never()).save(any());
    }
}
