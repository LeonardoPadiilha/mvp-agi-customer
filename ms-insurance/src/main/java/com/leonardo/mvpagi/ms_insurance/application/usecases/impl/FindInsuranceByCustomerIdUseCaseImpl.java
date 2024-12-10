package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.FindInsuranceByCustomerIdUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.NotFoundException;

public class FindInsuranceByCustomerIdUseCaseImpl implements FindInsuranceByCustomerIdUseCase {

    private final InsuranceGateway insuranceGateway;

    public FindInsuranceByCustomerIdUseCaseImpl(InsuranceGateway insuranceGateway) {
        this.insuranceGateway = insuranceGateway;
    }

    @Override
    public InsuranceDomain findInsuranceByCustomerId(Long customerId) {
        return insuranceGateway.findInsuranceByCustomerId(customerId).orElseThrow(() -> new NotFoundException("Customer not found"));
    }
}
