package com.leonardo.mvpagi.ms_insurance.application.usecases;

import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;

@FunctionalInterface
public interface CreateInsuranceUseCase {

    InsuranceDomain create(InsuranceDomain insuranceDomain);
}