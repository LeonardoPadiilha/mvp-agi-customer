package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.CreateInsuranceUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;

import static com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceStatusEnum.ACTIVE;

public class CreateInsuranceUseCaseImpl implements CreateInsuranceUseCase {

    private final InsuranceGateway insuranceGateway;

    public CreateInsuranceUseCaseImpl(InsuranceGateway insuranceGateway) {
        this.insuranceGateway = insuranceGateway;
    }

    @Override
    public InsuranceDomain create(InsuranceDomain insuranceDomain) {
        if(insuranceDomain.getInsuranceStatus() == null){
            insuranceDomain.setInsuranceStatus(ACTIVE);
        }
        return insuranceGateway.create(insuranceDomain);
    }
}
