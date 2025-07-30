package com.bankapp.banking_system.service;

import com.bankapp.banking_system.model.accounts.Account;
import com.bankapp.banking_system.model.embedded.Money;
import com.bankapp.banking_system.model.users.AccountHolder;
import com.bankapp.banking_system.repository.AccountHolderRepository;
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
    private AccountHolderRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private AccountHolder account;

    @BeforeEach
    void setUp() {
        account = new AccountHolder();
        account.setId(1L);
    }

    @Test
    void testUpdateAccountHolderMail_success() {
        // GIVEN
        String newName = "prueba";

        Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.ofNullable(account));
        Mockito.when(accountRepository.save(any(AccountHolder.class))).thenAnswer(i -> i.getArgument(0));

        // WHEN
        AccountHolder updatedAccount = accountService.updateAccountHolderMail(1L, newName);

        // THEN
        assertEquals(newName, updatedAccount.getName());
        verify(accountRepository).findById(1L);
        verify(accountRepository).save(account);
    }

    @Test
    void testUpdateAccountBalance_accountNotFound() {
        // GIVEN
        Long accountId = 1L;
        Money newBalance = new Money(new BigDecimal("1000.00"), Currency.getInstance("USD"));

        Mockito.when(accountRepository.findById(accountId)).thenReturn(Optional.empty());
        System.out.println("test");
        // THEN
        assertThrows(RuntimeException.class, () -> {
            // WHEN
            accountService.updateAccountBalance(accountId, newBalance);
            System.out.println("updating account balance...");
        });

        verify(accountRepository).findById(accountId);
        verify(accountRepository, never()).save(any());
        System.out.println("end of updateAccountBalance");
    }
}
