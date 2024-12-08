package com.leonardo.mvpagi.ms_customer.domain;

import com.leonardo.mvpagi.ms_customer.domain.exceptions.CustomValidationException;

import java.time.LocalDate;
import java.time.Period;

import static java.util.Objects.isNull;


public class CustomerDomain {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String phone;
    private String address;

    public CustomerDomain(String name, LocalDate birthDate, String cpf, String phone, String address) {
        this.name = nameValidation(name);
        this.birthDate = birthDateValidation(birthDate);
        this.cpf = cpfValidation(cpf);
        this.phone = phoneValidation(phone);
        this.address = address;
    }
    public CustomerDomain(){

    }

    private String phoneValidation(String phone) {
        return phone;
    }

    private static Long idValidation(final Long id) {
        if (isNull(id)) throw CustomValidationException.of("Customer Id", "cannot be null");
        if (id < 0) throw CustomValidationException.of("Customer Id", "cannot be negative");
        return id;
    }

    private static String cpfValidation(final String cpf) {
        if (isNull(cpf)) throw CustomValidationException.of("Customer CPF", "cannot be null");
        if (cpf.length() != 11) throw CustomValidationException.of("Customer CPF", "must be 11 positions");
        return cpf;
    }

    private static String nameValidation(final String name) {
        if (isNull(name)) throw CustomValidationException.of("Customer Name", "cannot be null");
        return name;
    }

    private static LocalDate birthDateValidation(final LocalDate birthDate) {
        if (isNull(birthDate)) throw CustomValidationException.of("Customer Birth Date", "cannot be null");
        LocalDate currentDate = LocalDate.now();
        boolean isOfLegalAge = Period.between(birthDate, currentDate).getYears() >= 18;
        if (!isOfLegalAge) throw
                CustomValidationException.of("Customer Birth Date", "must be at least 18 years ago");
        return birthDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
