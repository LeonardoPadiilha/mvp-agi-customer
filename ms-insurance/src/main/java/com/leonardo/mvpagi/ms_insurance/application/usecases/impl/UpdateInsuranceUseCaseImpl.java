package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.UpdateInsuranceUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.CustomValidationException;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.NotFoundException;

import static java.util.Objects.isNull;

public class UpdateInsuranceUseCaseImpl implements UpdateInsuranceUseCase {

    private final InsuranceGateway insuranceGateway;

    public UpdateInsuranceUseCaseImpl(InsuranceGateway insuranceGateway) {
        this.insuranceGateway = insuranceGateway;
    }

    @Override
    public void updateInsurance(InsuranceDomain insuranceDomain) {
        final var insuranceId = insuranceDomain.getId();
        if (isNull(insuranceId) || insuranceId < 0) throw CustomValidationException.of("Customer Id",
                "cannot be null or negative");
        if (isNull(insuranceDomain)) throw CustomValidationException.of("Customer", "cannot be null");

        insuranceGateway.findInsuranceById(insuranceId)
                .orElseThrow(() -> NotFoundException.of("Customer"));

        insuranceDomain.setId(insuranceId);
        insuranceGateway.updateInsurance(insuranceDomain);
    }
}
