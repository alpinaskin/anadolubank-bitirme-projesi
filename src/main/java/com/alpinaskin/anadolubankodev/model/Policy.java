package com.alpinaskin.anadolubankodev.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "no")
    private Integer no;
    @Column(name = "tc")
    private Integer tcNo;
    @Column(name = "accountId")
    private String accountId;
    @Column(name = "agencyId")
    private Integer agencyId;
    @Column(name = "type")
    private String policyType;
    @Column(name = "comission_rate")
    private Double comissionRate;
}
