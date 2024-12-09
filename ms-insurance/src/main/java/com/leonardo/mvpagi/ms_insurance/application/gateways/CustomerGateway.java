package com.leonardo.mvpagi.ms_insurance.application.gateways;

import com.leonardo.mvpagi.ms_insurance.domain.entities.CustomerDomain;

public interface CustomerGateway {

    CustomerDomain findCustomerByCpf(String cpf);
}
