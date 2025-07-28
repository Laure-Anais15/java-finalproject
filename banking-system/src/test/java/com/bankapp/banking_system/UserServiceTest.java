package com.bankapp.banking_system.service;

import com.bankapp.banking_system.model.users.AccountHolder;
import com.bankapp.banking_system.model.users.User;
import com.bankapp.banking_system.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setName("Alice");

        when(userRepository.save(user)).thenReturn(user);

        AccountHolder result = userService.createUser(user);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetAllUsers() {
        AccountHolder user1 = new AccountHolder();
        user1.setName("Alice");
        AccountHolder user2 = new AccountHolder();
        user2.setName("Bob");

        List<AccountHolder> userList = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(userList);

        List<AccountHolder> result = userService.getAllUsers();

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Bob", result.get(1).getName());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testFindUserById() {
        AccountHolder user = new AccountHolder();
        user.setId(1L);
        user.setName("Alice");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        AccountHolder result = userService.findUserById(1L);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        assertEquals(1L, result.getId());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;

        doNothing().when(userRepository).deleteById(userId);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }
}
