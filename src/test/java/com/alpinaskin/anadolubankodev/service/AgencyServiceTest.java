package com.alpinaskin.anadolubankodev.service;

import com.alpinaskin.anadolubankodev.model.Agency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgencyServiceTest {
    @Autowired
    private AgencyService agencyService;

    @Test
    void getAll() {
        List<Agency> agencies = agencyService.getAll();
        assertEquals(43, agencies.size());
    }

    @Test
    void getOneById() {
        Agency agency = agencyService.getOneById(1);
        assertEquals("ACE EUROPEAN GROUP LTD.MRK.", agency.getName());
    }
}