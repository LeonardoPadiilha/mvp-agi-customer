package com.leonardo.mvpagi.ms_customer.infra.persistence.controllers.dtos;

import lombok.Data;

@Data
public class CustomerDto {
//    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String birthDate;
    private String address;
}
