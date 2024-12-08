package com.leonardo.mvpagi.ms_customer.application.usecases.impl;

import com.leonardo.mvpagi.ms_customer.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_customer.application.usecases.FindCustomerByCpfUseCase;
import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.CustomValidationException;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.NotFoundException;

import static java.util.Objects.isNull;

public class FindCustomerByCpfUseCaseImpl implements FindCustomerByCpfUseCase {

    private final CustomerGateway customerGateway;

    public FindCustomerByCpfUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CustomerDomain execute(String cpf) {
        if (isNull(cpf) || cpf.length() != 11) throw CustomValidationException.of("Customer CPF",
                "invalid");
        return customerGateway.findCustomerByCpf(cpf)
                .orElseThrow(() -> NotFoundException.of("Customer"));
    }
}
