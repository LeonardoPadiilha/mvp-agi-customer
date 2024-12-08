package com.leonardo.mvpagi.ms_customer.application.usecases.impl;

import com.leonardo.mvpagi.ms_customer.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_customer.application.usecases.UpdateCustomerUseCase;
import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.CustomValidationException;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.NotFoundException;

import static java.util.Objects.isNull;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public UpdateCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public void update(Long customerId, CustomerDomain customer) {
        if (isNull(customerId) || customerId < 0) throw CustomValidationException.of("Customer Id",
                "cannot be null or negative");
        if (isNull(customer)) throw CustomValidationException.of("Customer", "cannot be null");

        customerGateway.findCustomerById(customerId)
                .orElseThrow(() -> NotFoundException.of("Customer"));

        customer.setId(customerId);
        customerGateway.update(customer);
    }
}
