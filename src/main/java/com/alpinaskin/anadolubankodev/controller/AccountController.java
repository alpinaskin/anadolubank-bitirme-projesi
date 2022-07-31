package com.alpinaskin.anadolubankodev.controller;

import com.alpinaskin.anadolubankodev.dto.response.AccountGenderResponse;
import com.alpinaskin.anadolubankodev.dto.response.AccountPolicyResponse;
import com.alpinaskin.anadolubankodev.model.Account;
import com.alpinaskin.anadolubankodev.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/getGenders")
    public List<AccountGenderResponse> getAccountGenders() { return accountService.getAccountGenders(); }

    public List<AccountPolicyResponse> getAccountPolicies() {
        return null;
    }
}
