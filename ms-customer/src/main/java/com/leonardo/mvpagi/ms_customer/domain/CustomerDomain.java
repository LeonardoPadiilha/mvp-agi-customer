package com.leonardo.mvpagi.ms_customer.domain;

import com.leonardo.mvpagi.ms_customer.domain.exceptions.CustomValidationException;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

import static java.util.Objects.isNull;

@Data
public class CustomerDomain {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String phone;
    private String address;



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
}
