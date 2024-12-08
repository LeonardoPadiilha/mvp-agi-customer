package com.leonardo.mvpagi.ms_customer.config;

import com.leonardo.mvpagi.ms_customer.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_customer.application.usecases.*;
import com.leonardo.mvpagi.ms_customer.application.usecases.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway) {
        return new CreateCustomerUseCaseImpl(customerGateway);
    }

    @Bean
    public FindCustomerByIdUseCase getCustomerByIdUseCase(CustomerGateway customerGateway) {
        return new FindCustomerByIdUseCaseImpl(customerGateway);
    }

    @Bean
    public FindCustomerByCpfUseCase findCustomerByCpfUseCase(CustomerGateway customerGateway) {
        return new FindCustomerByCpfUseCaseImpl(customerGateway);
    }

    @Bean
    public FindAllCustomersUseCase findAllCustomersUseCase(CustomerGateway customerGateway) {
        return new FindAllCustomersUseCaseImpl(customerGateway);
    }

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(CustomerGateway customerGateway, FindCustomerByIdUseCase findCustomerByIdUseCase) {
        return new DeleteCustomerByIdUseCaseImpl(customerGateway, findCustomerByIdUseCase);
    }

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(CustomerGateway customerGateway) {
        return new UpdateCustomerUseCaseImpl(customerGateway);
    }
}
