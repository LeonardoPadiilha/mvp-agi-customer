package com.leonardo.mvpagi.ms_insurance.infra.controllers.dtos;

import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceStatusEnum;
import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceTypeEnum;

public class InsuranceDto {

    private Long id;
    private String policyNumber;
    private Long customerId;
    private InsuranceTypeEnum insuranceType;
    private String premiumAmount;
    private String policyStartDate;
    private String policyEndDate;
    private InsuranceStatusEnum insuranceStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public InsuranceTypeEnum getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceTypeEnum insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(String premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(String policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    public String getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(String policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public InsuranceStatusEnum getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(InsuranceStatusEnum insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }
}
