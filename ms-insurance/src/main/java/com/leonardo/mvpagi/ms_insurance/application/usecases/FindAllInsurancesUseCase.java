package com.leonardo.mvpagi.ms_insurance.application.usecases;

import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;

import java.util.List;

@FunctionalInterface
public interface FindAllInsurancesUseCase {

    List<InsuranceDomain> findAllInsurances();
}
