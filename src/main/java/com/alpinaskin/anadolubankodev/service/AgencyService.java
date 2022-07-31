package com.alpinaskin.anadolubankodev.service;

import com.alpinaskin.anadolubankodev.model.Agency;
import com.alpinaskin.anadolubankodev.repository.AgencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AgencyService {
    private final AgencyRepository agencyRepository;

    public List<Agency> getAll() {
        log.info("Agency Service called");
        return agencyRepository.getAll();
    }

    public Agency getOneById(int agencyId) {
        return agencyRepository.getOne(agencyId);
    }
}
