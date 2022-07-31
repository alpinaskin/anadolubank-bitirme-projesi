package com.alpinaskin.anadolubankodev.controller;

import com.alpinaskin.anadolubankodev.model.Agency;
import com.alpinaskin.anadolubankodev.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/agency")
public class AgencyController {
    private final AgencyService agencyService;

    @GetMapping
    public List<Agency> getAll() {
        return agencyService.getAll();
    }

}
