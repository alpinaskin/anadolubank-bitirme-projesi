package com.alpinaskin.anadolubankodev.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name ="policy_options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "net")
    private Double net;
    @Column(name = "gross")
    private Double gross;
    @Column(name = "policy_id")
    private Integer policy_id;
}
