package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.FindAllInsurancesUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;

import java.util.List;

public class FindAllInsurancesUseCaseImpl implements FindAllInsurancesUseCase {

    private final InsuranceGateway insuranceGateway;

    public FindAllInsurancesUseCaseImpl(InsuranceGateway insuranceGateway) {
        this.insuranceGateway = insuranceGateway;
    }

    @Override
    public List<InsuranceDomain> findAllInsurances() {
      return insuranceGateway.findAllInsurances();
    }
}
