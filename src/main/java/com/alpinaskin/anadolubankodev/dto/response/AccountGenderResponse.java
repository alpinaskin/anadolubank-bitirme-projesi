package com.alpinaskin.anadolubankodev.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountGenderResponse {
    private String gender;
    private Long number;
}
