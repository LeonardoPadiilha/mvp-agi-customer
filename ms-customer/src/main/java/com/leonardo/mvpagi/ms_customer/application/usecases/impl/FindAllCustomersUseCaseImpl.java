package com.leonardo.mvpagi.ms_customer.application.usecases.impl;

import com.leonardo.mvpagi.ms_customer.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_customer.application.usecases.FindAllCustomersUseCase;
import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;

import java.util.List;

public class FindAllCustomersUseCaseImpl implements FindAllCustomersUseCase {

    private final CustomerGateway customerGateway;

    public FindAllCustomersUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<CustomerDomain> execute() {
        return customerGateway.findAllCustomers();
    }
}
