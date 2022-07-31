package com.alpinaskin.anadolubankodev.service;

import com.alpinaskin.anadolubankodev.dto.response.AccountGenderResponse;
import com.alpinaskin.anadolubankodev.dto.response.AccountPolicyResponse;
import com.alpinaskin.anadolubankodev.model.Account;
import com.alpinaskin.anadolubankodev.model.Option;
import com.alpinaskin.anadolubankodev.model.Policy;
import com.alpinaskin.anadolubankodev.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountService extends AbstractDistinctableService {
    private final AccountRepository accountRepository;
    private final PolicyService policyService;
    private final OptionService optionService;

    public List<Account> getAll() {
        log.info("Account Service called");
        return accountRepository.getAll();
    };

    public Account getOneById(int accountId) {
        return accountRepository.getOne(accountId);
    }

    public List<AccountGenderResponse> getAccountGenders() {
        List<AccountGenderResponse> response = new ArrayList<>();
        List<Account> accounts = this.getAll();
        List<String> genders = accounts.stream()
                .filter(distinctByKey(Account::getGender))
                .map(Account::getGender)
                .collect(Collectors.toList());

        for(String gender : genders) {
            long count = accounts.stream()
                    .map(Account::getGender)
                    .filter(s -> s.equals(gender))
                    .count();
            response.add(new AccountGenderResponse(gender, count));
        }

        return response;
    }

    public List<AccountPolicyResponse> getAccountPolicies(int accountId) {
        List<AccountPolicyResponse> response = new ArrayList<>();
        List<Policy> policies = policyService.getPoliciesByAccountId(accountId);
        for(Policy policy : policies) {
            Option option = optionService.getOptionByPolicyId(policy.getId());
            response.add(new AccountPolicyResponse(policy.getStartDate(),
                    policy.getEndDate(),
                    option.getNet(),
                    option.getGross(),
                    policy.getComissionRate()));
        }
        return response;
    }
}
