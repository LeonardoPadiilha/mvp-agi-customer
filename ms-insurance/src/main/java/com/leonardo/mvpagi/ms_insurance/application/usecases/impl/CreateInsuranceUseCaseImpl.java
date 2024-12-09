package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.CreateInsuranceUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.CustomerDomain;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.NotFoundException;

import static com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceStatusEnum.ACTIVE;

public class CreateInsuranceUseCaseImpl implements CreateInsuranceUseCase {

    private final InsuranceGateway insuranceGateway;
    private final CustomerGateway customerGateway;

    public CreateInsuranceUseCaseImpl(InsuranceGateway insuranceGateway, CustomerGateway customerGateway) {
        this.insuranceGateway = insuranceGateway;
        this.customerGateway = customerGateway;
    }

    @Override
    public InsuranceDomain create(InsuranceDomain insuranceDomain) {
        final var cpf = insuranceDomain.getCustomerCpf();
        customerGateway.findCustomerByCpf(cpf);
        if(cpf == null){
            throw new NotFoundException("CPF informado não foi encontrado");
        }
        if(insuranceDomain.getInsuranceStatus() == null){
            insuranceDomain.setInsuranceStatus(ACTIVE);
        }
        return insuranceGateway.create(insuranceDomain);
    }
}
