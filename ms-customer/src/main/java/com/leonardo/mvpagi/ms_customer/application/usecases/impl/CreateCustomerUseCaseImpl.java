package com.leonardo.mvpagi.ms_customer.application.usecases.impl;

import com.leonardo.mvpagi.ms_customer.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_customer.application.usecases.CreateCustomerUseCase;
import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.CustomValidationException;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.NotFoundException;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public CreateCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CustomerDomain execute(CustomerDomain customer) {
        var cpf = customerGateway.findCustomerByCpf(customer.getCpf());
        if(cpf.isPresent()) {
            throw new CustomValidationException("cpf", "customer already exists");
        }
        return customerGateway.create(customer);
    }
}
