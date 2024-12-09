package com.leonardo.mvpagi.ms_insurance.domain.entities;

import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceStatusEnum;
import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InsuranceDomain {
    private Long id;
    private String policyNumber;
    private Long customerId;
    private String customerCpf;
    private InsuranceTypeEnum insuranceType;
    private BigDecimal premiumAmount;
    private LocalDateTime policyStartDate = LocalDateTime.now().withNano(0);
    private LocalDateTime policyEndDate;
    private InsuranceStatusEnum insuranceStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCpf() {
        return customerCpf;
    }

    public void setCustomerCpf(String customerCpf) {
        this.customerCpf = customerCpf;
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

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public LocalDateTime getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(LocalDateTime policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    public LocalDateTime getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(LocalDateTime policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public InsuranceStatusEnum getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(InsuranceStatusEnum insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }
}
