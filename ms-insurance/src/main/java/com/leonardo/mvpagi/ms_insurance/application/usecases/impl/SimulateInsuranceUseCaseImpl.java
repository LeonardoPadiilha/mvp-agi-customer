package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.SimulateInsuranceUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.CustomerDomain;
import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceTypeEnum;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.NotFoundException;


public class SimulateInsuranceUseCaseImpl implements SimulateInsuranceUseCase {

    private final CustomerGateway customerGateway;

    public SimulateInsuranceUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CustomerDomain execute(String cpf, InsuranceTypeEnum insuranceType) {
        var customer = customerGateway.findCustomerByCpf(cpf);
        if (customer == null) {
            throw new NotFoundException("CPF informado não foi encontrado.");
        }
        return customer;
    }
}
