package com.leonardo.mvpagi.ms_insurance.config;

import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.application.usecases.CreateInsuranceUseCase;
import com.leonardo.mvpagi.ms_insurance.application.usecases.impl.CreateInsuranceUseCaseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateInsuranceUseCase createInsuranceUseCase(InsuranceGateway insuranceGateway) {
        return new CreateInsuranceUseCaseImpl(insuranceGateway);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
