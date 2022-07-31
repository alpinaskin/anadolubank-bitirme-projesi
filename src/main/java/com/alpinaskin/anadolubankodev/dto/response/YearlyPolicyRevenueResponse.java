package com.alpinaskin.anadolubankodev.dto.response;

import lombok.Value;

@Value
public class YearlyPolicyRevenueResponse {
    private Integer year;
    private Long net;
    private Long gross;
}
