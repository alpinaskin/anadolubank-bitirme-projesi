package com.alpinaskin.anadolubankodev.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPolicyResponse {
    private Date startDate;
    private Date endDate;
    private Double net;
    private Double gross;
    private Double comissionRate;
}
