package com.leonardo.mvpagi.ms_customer.application.usecases;

import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;

import java.util.List;

@FunctionalInterface
public interface FindAllCustomersUseCase {

    List<CustomerDomain> execute();
}
