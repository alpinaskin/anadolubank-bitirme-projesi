package com.alpinaskin.anadolubankodev.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyExtendedResponse {
    private String firstName;
    private String lastName;
    private String agencyName;
    private Date startDate;
    private Date endDate;
    private Double commissionRate;
    private Double net;
    private Double gross;
}
