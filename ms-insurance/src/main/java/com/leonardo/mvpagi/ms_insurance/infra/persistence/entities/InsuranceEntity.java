package com.leonardo.mvpagi.ms_insurance.infra.persistence.entities;

import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceStatusEnum;
import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "insurance")
public class InsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String policyNumber;

    @NotNull
    private Long customerId;

    @NotNull
    private String customerCpf;

    @NotNull
    @Enumerated(EnumType.STRING)
    private InsuranceTypeEnum insuranceType;

    @NotNull
    private BigDecimal premiumAmount;

    private LocalDateTime policyStartDate = LocalDateTime.now();

    private LocalDateTime policyEndDate;
    @NotNull
    @Enumerated(EnumType.STRING)
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
