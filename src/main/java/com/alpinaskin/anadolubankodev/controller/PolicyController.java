package com.alpinaskin.anadolubankodev.controller;

import com.alpinaskin.anadolubankodev.dto.request.PolicyRequest;
import com.alpinaskin.anadolubankodev.dto.response.AccountPolicyResponse;
import com.alpinaskin.anadolubankodev.dto.response.PolicyExtendedResponse;
import com.alpinaskin.anadolubankodev.dto.response.PolicyTypeResponse;
import com.alpinaskin.anadolubankodev.dto.response.YearlyPolicyRevenueResponse;
import com.alpinaskin.anadolubankodev.model.Account;
import com.alpinaskin.anadolubankodev.model.Option;
import com.alpinaskin.anadolubankodev.model.Policy;
import com.alpinaskin.anadolubankodev.service.AccountService;
import com.alpinaskin.anadolubankodev.service.OptionService;
import com.alpinaskin.anadolubankodev.service.PolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/policy")
@RequiredArgsConstructor
public class PolicyController {
    private final PolicyService policyService;
    private final AccountService accountService;
    private final OptionService optionService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<PolicyTypeResponse> getAllPolicy(){ return policyService.getAllPolicyTypes(); }

    @GetMapping("/yearlyPolicyRevenue")
    public List<YearlyPolicyRevenueResponse> getPolicyRevenues(){
        List<Policy> policies = this.policyService.getAll();

        List<YearlyPolicyRevenueResponse> response = policies.stream()
                .map(policy -> modelMapper.map(policy,YearlyPolicyRevenueResponse.class))
                .collect(Collectors.toList());

        return response;
    }

    @PostMapping
    public List<AccountPolicyResponse> getPolicyByAccountId(@RequestBody @Validated PolicyRequest policyRequest){
        List<AccountPolicyResponse> response =accountService.getAccountPolicies(policyRequest.getAccountId());
        log.info("AccountPolicyResponse: {}", response);
        return response;
                //this.policyService.getPoliciesByAccountId(policyRequest.getAccountId());
    }

    @GetMapping("/extendedPolicy")
    public List<PolicyExtendedResponse> getAllPolicyExtended(){
        List<PolicyExtendedResponse> responses = policyService.getAllPolicyExtended();
        log.info("POLİCY EXTENDED : {}", responses.get(0));
       return responses;
    }

}
