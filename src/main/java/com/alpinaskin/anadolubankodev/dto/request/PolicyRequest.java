package com.alpinaskin.anadolubankodev.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyRequest {
    @NotNull
    @JsonProperty("accountId")
    int accountId;
}
