package com.leonardo.mvpagi.ms_insurance.infra.gateways;

import com.leonardo.mvpagi.ms_insurance.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_insurance.domain.entities.CustomerDomain;
import com.leonardo.mvpagi.ms_insurance.infra.client.FindCustomerClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerGatewayRepository implements CustomerGateway {

    private final FindCustomerClient findCustomerClient;
    private final ModelMapper modelMapper;

    public CustomerGatewayRepository(FindCustomerClient findCustomerClient, ModelMapper modelMapper) {
        this.findCustomerClient = findCustomerClient;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDomain findCustomerByCpf(String cpf) {
        final var customer = findCustomerClient.findCustomerByCpf(cpf);
        return modelMapper.map(customer, CustomerDomain.class);
    }
}
