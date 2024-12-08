package com.leonardo.mvpagi.ms_customer.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String phone;
    private String address;
}
