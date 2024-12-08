package com.leonardo.mvpagi.ms_customer.application.gateways;

import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;

import java.util.List;
import java.util.Optional;

public interface CustomerGateway {
    CustomerDomain create(CustomerDomain customer);

    List<CustomerDomain> findAllCustomers();

    Optional<CustomerDomain> findCustomerById(Long id);

    Optional<CustomerDomain> findCustomerByCpf(String cpf);

    void update(CustomerDomain customer);

    void delete(Long id);
}
