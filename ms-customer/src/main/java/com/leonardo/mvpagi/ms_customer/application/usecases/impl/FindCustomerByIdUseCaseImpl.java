package com.leonardo.mvpagi.ms_customer.application.usecases.impl;

import com.leonardo.mvpagi.ms_customer.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_customer.application.usecases.FindCustomerByIdUseCase;
import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.CustomValidationException;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.NotFoundException;

import static java.util.Objects.isNull;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    public final CustomerGateway customerGateway;

    public FindCustomerByIdUseCaseImpl(com.leonardo.mvpagi.ms_customer.application.gateways.CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CustomerDomain execute(Long id) {
        if (isNull(id) || id < 0) throw CustomValidationException.of("Customer Id",
                "cannot be null or negative");
        return customerGateway.findCustomerById(id)
                .orElseThrow(() -> NotFoundException.of("Customer"));
    }
}
