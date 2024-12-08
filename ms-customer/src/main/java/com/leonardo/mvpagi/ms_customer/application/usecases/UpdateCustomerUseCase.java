package com.leonardo.mvpagi.ms_customer.application.usecases;

import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;

@FunctionalInterface
public interface UpdateCustomerUseCase {

    void update(Long id, CustomerDomain customer);
}
