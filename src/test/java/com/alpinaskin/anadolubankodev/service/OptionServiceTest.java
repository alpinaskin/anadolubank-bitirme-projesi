package com.alpinaskin.anadolubankodev.service;

import com.alpinaskin.anadolubankodev.model.Option;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class OptionServiceTest {
    @Autowired
    private OptionService optionService;

    @Test
    void getOptionByPolicyId() {
        Option option = optionService.getOptionByPolicyId(1);
        assertEquals(Double.valueOf("2383.44"), option.getNet());
        assertEquals(Double.valueOf("2555.62"), option.getGross());
    }
}