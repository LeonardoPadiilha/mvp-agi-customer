package com.leonardo.mvpagi.ms_insurance.application.gateways;

import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;

import java.util.List;
import java.util.Optional;

public interface InsuranceGateway {
    InsuranceDomain create(InsuranceDomain insuranceDomain);

    List<InsuranceDomain> findAllInsurances();

    Optional<InsuranceDomain> findInsuranceById(Long id);

    Optional<InsuranceDomain> findInsuranceByCustomerId(Long customerId);

    void updateInsurance(InsuranceDomain insuranceDomain);

    void deleteInsurance(Long id);
}
