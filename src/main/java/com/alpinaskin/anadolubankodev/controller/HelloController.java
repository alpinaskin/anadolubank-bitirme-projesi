package com.alpinaskin.anadolubankodev.controller;

import com.alpinaskin.anadolubankodev.Response;
import com.alpinaskin.anadolubankodev.dto.request.PolicyRequest;
import com.alpinaskin.anadolubankodev.dto.response.PolicyTypeResponse;
import com.alpinaskin.anadolubankodev.dto.response.YearlyPolicyRevenueResponse;
import com.alpinaskin.anadolubankodev.model.Policy;
import com.alpinaskin.anadolubankodev.repository.PolicyRepository;
import com.alpinaskin.anadolubankodev.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
public class HelloController {

    private final PolicyService policyService;
    private final ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response hello(){
        return new Response("Hello From Spring boot");
    }

    @RequestMapping("/policy")
    public List<PolicyTypeResponse> getPolicy(){
        List<PolicyTypeResponse> response = new ArrayList<>();
        List<Policy> policies = policyService.getAll();
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

    @GetMapping("/yearlyPolicyRevenue")
    public List<YearlyPolicyRevenueResponse> getPolicyRevenues(){
        List<Policy> policies = this.policyService.getAll();

        List<YearlyPolicyRevenueResponse> response = policies.stream()
                .map(policy -> modelMapper.map(policy,YearlyPolicyRevenueResponse.class))
                .collect(Collectors.toList());

        return response;
    }

    @PostMapping("/policy")
    public List<Policy> getPolicyByAccountId(@RequestBody @Validated PolicyRequest policyRequest){
        return this.policyService.getPoliciesByAccountId(policyRequest.getAccountId());
    }
    public static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
