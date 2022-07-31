package com.alpinaskin.anadolubankodev.service;

import com.alpinaskin.anadolubankodev.model.Option;
import com.alpinaskin.anadolubankodev.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OptionService {
    private final OptionRepository optionRepository;

    public Option getOptionByPolicyId(int policyId) {
        return optionRepository.getOptionByPolicyId(policyId);
    }
}
