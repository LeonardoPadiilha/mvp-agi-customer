package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.FindInsuranceByIdUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.NotFoundException;

public class FindInsuranceByIdUseCaseImpl implements FindInsuranceByIdUseCase {

    private final InsuranceGateway insuranceGateway;

    public FindInsuranceByIdUseCaseImpl(InsuranceGateway insuranceGateway) {
        this.insuranceGateway = insuranceGateway;
    }

    @Override
    public InsuranceDomain findInsuranceById(Long id) {
        return insuranceGateway.findInsuranceById(id).orElseThrow(() -> new NotFoundException(id.toString()));
    }
}
