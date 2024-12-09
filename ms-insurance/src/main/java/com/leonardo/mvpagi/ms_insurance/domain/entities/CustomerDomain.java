package com.leonardo.mvpagi.ms_insurance.domain.entities;

import java.time.LocalDate;

public class CustomerDomain {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String phone;

    public CustomerDomain(){}

    public CustomerDomain(String name, LocalDate birthDate, String cpf, String phone) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
