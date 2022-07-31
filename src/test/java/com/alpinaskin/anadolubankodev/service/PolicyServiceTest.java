package com.alpinaskin.anadolubankodev.service;

import com.alpinaskin.anadolubankodev.dto.response.PolicyTypeResponse;
import com.alpinaskin.anadolubankodev.model.Policy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolicyServiceTest {

    @Autowired
    private PolicyService policyService;

    @Test
    void getAll() {
        List<Policy> policies = policyService.getAll();
        assertEquals(1000, policies.size());
    }

    @Test
    void getAllPolicyTypes() {
        List<PolicyTypeResponse> policyTypeResponse = policyService.getAllPolicyTypes();
        assertEquals(1000, policyTypeResponse.size());
    }

    @Test
    void getPoliciesByAccountId() {
        List<Policy> policies = policyService.getPoliciesByAccountId(1);
        assertEquals(9, policies.size());
    }
}