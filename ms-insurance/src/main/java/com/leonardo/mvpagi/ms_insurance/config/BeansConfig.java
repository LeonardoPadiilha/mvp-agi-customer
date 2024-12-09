package com.leonardo.mvpagi.ms_insurance.config;

import com.leonardo.mvpagi.ms_insurance.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.*;
import com.leonardo.mvpagi.ms_insurance.application.usecases.impl.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateInsuranceUseCase createInsuranceUseCase(InsuranceGateway insuranceGateway, CustomerGateway customerGateway) {
        return new CreateInsuranceUseCaseImpl(insuranceGateway, customerGateway);
    }

    @Bean
    public FindInsuranceByIdUseCase findInsuranceByIdUseCase(InsuranceGateway insuranceGateway) {
        return new FindInsuranceByIdUseCaseImpl(insuranceGateway);
    }

    @Bean
    public FindInsuranceByCustomerIdUseCase findInsuranceByCustomerIdUseCase(InsuranceGateway insuranceGateway) {
        return new FindInsuranceByCustomerIdUseCaseImpl(insuranceGateway);
    }

    @Bean
    public FindAllInsurancesUseCase findAllInsurancesUseCase(InsuranceGateway insuranceGateway) {
        return new FindAllInsurancesUseCaseImpl(insuranceGateway);
    }

    @Bean
    public DeleteInsuranceUseCase deleteInsuranceUseCase(InsuranceGateway insuranceGateway, FindInsuranceByIdUseCase findInsuranceByIdUseCase) {
        return new DeleteInsuranceUseCaseImpl(insuranceGateway, findInsuranceByIdUseCase);
    }

    @Bean
    public SimulateInsuranceUseCase simulateInsuranceUseCase(CustomerGateway customerGateway) {
        return new SimulateInsuranceUseCaseImpl(customerGateway);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
