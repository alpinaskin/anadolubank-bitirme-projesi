package com.alpinaskin.anadolubankodev.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
@Getter
@Setter
public class PolicyTypeResponse {
    private String policyType;
    private Long number;
}
