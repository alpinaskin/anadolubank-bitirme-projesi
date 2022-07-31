package com.alpinaskin.anadolubankodev.service;

import com.alpinaskin.anadolubankodev.dto.response.PolicyExtendedResponse;
import com.alpinaskin.anadolubankodev.dto.response.PolicyTypeResponse;
import com.alpinaskin.anadolubankodev.model.Account;
import com.alpinaskin.anadolubankodev.model.Agency;
import com.alpinaskin.anadolubankodev.model.Option;
import com.alpinaskin.anadolubankodev.model.Policy;
import com.alpinaskin.anadolubankodev.repository.AccountRepository;
import com.alpinaskin.anadolubankodev.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PolicyService extends AbstractDistinctableService {
    private final PolicyRepository policyRepository;
    private final AccountRepository accountRepository;
    private final AgencyService agencyService;
    private final OptionService optionService;

    public List<Policy> getAll(){
        log.info("Policy Service called");
        return policyRepository.getAll();
    }

    public List<PolicyTypeResponse> getAllPolicyTypes(){
        List<PolicyTypeResponse> response = new ArrayList<>();
        List<Policy> policies = this.getAll();
        List<String> policyTypes = policies.stream()
                .filter(distinctByKey(Policy::getPolicyType))
                .map(Policy::getPolicyType)
                .collect(Collectors.toList());

        for(String type : policyTypes) {
            long count = policies.stream()
                    .map(p -> p.getPolicyType())
                    .filter(s -> s.equals(type))
                    .count();
            response.add(new PolicyTypeResponse(type, count));
        }

        return response;
    }
    public List<Policy> getPoliciesByAccountId(int accountId) {
        if(accountId < 0)
            throw new RuntimeException("AccountId cannot be negative number");

        return policyRepository.getAllByAccountId(accountId);
    }

    public List<PolicyExtendedResponse> getAllPolicyExtended(){
        List<PolicyExtendedResponse> response = new ArrayList<>();

        List<Policy> policies = this.getAll();
        for(Policy policy : policies) {
            Option option = optionService.getOptionByPolicyId(policy.getId());
            log.info("OPTİON : {}", option);
            Account account = accountRepository.getOne(Integer.valueOf(policy.getAccountId()));
            log.info("ACCOUNT: {}", account);
            Agency agency = agencyService.getOneById(policy.getAgencyId());
            response.add(new PolicyExtendedResponse(account.getFirstName(),
                    account.getLastName(),
                    agency.getName(),
                    policy.getStartDate(),
                    policy.getEndDate(),
                    policy.getComissionRate(),
                    option.getNet(),
                    option.getGross()));
        }
        log.info("RESPONSE: {}", response.get(0));

        return response;
    }
}
