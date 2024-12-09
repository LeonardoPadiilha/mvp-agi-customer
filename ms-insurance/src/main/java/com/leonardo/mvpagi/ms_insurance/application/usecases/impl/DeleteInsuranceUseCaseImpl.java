package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.DeleteInsuranceUseCase;
import com.leonardo.mvpagi.ms_insurance.application.usecases.FindInsuranceByIdUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceStatusEnum;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.CustomValidationException;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.NotFoundException;

import static com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceStatusEnum.ACTIVE;
import static com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceStatusEnum.CANCELED;
import static java.util.Objects.isNull;

public class DeleteInsuranceUseCaseImpl implements DeleteInsuranceUseCase {

   private final InsuranceGateway insuranceGateway;
   private final FindInsuranceByIdUseCase findInsuranceByIdUseCase;

    public DeleteInsuranceUseCaseImpl(InsuranceGateway insuranceGateway, FindInsuranceByIdUseCase findInsuranceByIdUseCase) {
        this.insuranceGateway = insuranceGateway;
        this.findInsuranceByIdUseCase = findInsuranceByIdUseCase;
    }

    @Override
    public void deleteInsurance(Long id) {
        if (isNull(id) || id < 0) throw CustomValidationException.of("Customer Id",
                "cannot be null or negative");
        final var insurance = findInsuranceByIdUseCase.findInsuranceById(id);
        if(!insurance.getInsuranceStatus().equals(CANCELED)){
            throw CustomValidationException.of("Insurance", "cannot be deleted because status is different from CANCELED");
        }
        if (isNull(insurance)) {
            throw NotFoundException.of("Insurance");
        }
        insuranceGateway.deleteInsurance(id);
    }
}
