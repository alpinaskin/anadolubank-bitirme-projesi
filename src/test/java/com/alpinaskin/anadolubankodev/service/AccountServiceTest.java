package com.alpinaskin.anadolubankodev.service;

import com.alpinaskin.anadolubankodev.dto.response.AccountGenderResponse;
import com.alpinaskin.anadolubankodev.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void getAll() {
        // Before
        int expected = 150;
        //Then
        List<Account> accounts = accountService.getAll();
        int actual = accounts.size();

        assertEquals(expected, actual);
    }

    @Test
    void getOneById() {
        Account account = accountService.getOneById(1);

        assertNotNull(account);
        assertEquals("Rosalie", account.getFirstName());
    }

    @Test
    void getAccountGenders() {
        assertInstanceOf(AccountGenderResponse.class, accountService.getAccountGenders().get(0));
    }
}