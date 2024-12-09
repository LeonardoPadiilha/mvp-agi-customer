package com.leonardo.mvpagi.ms_insurance.application.usecases.impl;

import com.leonardo.mvpagi.ms_insurance.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.SimulateInsuranceUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.CustomerDomain;
import com.leonardo.mvpagi.ms_insurance.domain.enums.InsuranceTypeEnum;
import com.leonardo.mvpagi.ms_insurance.domain.exceptions.NotFoundException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimulateInsuranceUseCaseImpl implements SimulateInsuranceUseCase {

    private final CustomerGateway customerGateway;

    public SimulateInsuranceUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
//    @CircuitBreaker(name = "default", fallbackMethod = "fallbackSimulateInsurance")
    public CustomerDomain execute(String cpf, InsuranceTypeEnum insuranceType) {
        var customer = customerGateway.findCustomerByCpf(cpf);
        if (customer == null) {
            throw new NotFoundException("CPF informado não foi encontrado.");
        }
        return customer;
    }
//    // Fallback method
//    public CustomerDomain fallbackSimulateInsurance(String cpf, InsuranceTypeEnum insuranceType, Throwable t) {
//        log.info("Falha ao buscar cliente com CPF: {}, erro: {}", cpf, t.getMessage());
//        // Retorna um cliente vazio ou um valor default em caso de falha
//        return new CustomerDomain();
//    }
}
