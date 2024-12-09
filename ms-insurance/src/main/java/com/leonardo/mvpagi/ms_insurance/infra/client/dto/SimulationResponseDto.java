package com.leonardo.mvpagi.ms_insurance.infra.client.dto;

import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceTypeEnum;
import com.leonardo.mvpagi.ms_insurance.infra.controllers.dtos.CustomerDto;

public class SimulationResponseDto {
    private CustomerDto customer;
    private InsuranceTypeEnum insuranceType;

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public InsuranceTypeEnum getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceTypeEnum insuranceType) {
        this.insuranceType = insuranceType;
    }
}
