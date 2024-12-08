package com.leonardo.mvpagi.ms_customer.application.usecases;

@FunctionalInterface
public interface DeleteCustomerByIdUseCase {

    void execute(Long id);
}
