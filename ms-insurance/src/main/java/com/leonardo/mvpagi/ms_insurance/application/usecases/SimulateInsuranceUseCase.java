package com.leonardo.mvpagi.ms_insurance.application.usecases;

import com.leonardo.mvpagi.ms_insurance.domain.entities.CustomerDomain;
import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceTypeEnum;

@FunctionalInterface
public interface SimulateInsuranceUseCase {

    CustomerDomain execute(String cpf, InsuranceTypeEnum insuranceType);
}
