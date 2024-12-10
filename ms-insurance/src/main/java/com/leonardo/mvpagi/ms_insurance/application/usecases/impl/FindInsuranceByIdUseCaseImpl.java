package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.FindInsuranceByIdUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.CustomValidationException;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.NotFoundException;

import static java.util.Objects.isNull;

public class FindInsuranceByIdUseCaseImpl implements FindInsuranceByIdUseCase {

    private final InsuranceGateway insuranceGateway;

    public FindInsuranceByIdUseCaseImpl(InsuranceGateway insuranceGateway) {
        this.insuranceGateway = insuranceGateway;
    }

    @Override
    public InsuranceDomain findInsuranceById(Long id) {
        if (isNull(id) || id < 0) throw CustomValidationException.of("Customer Id",
                "cannot be null or negative");
        return insuranceGateway.findInsuranceById(id)
                .orElseThrow(() -> NotFoundException.of("Customer"));
    }
}
