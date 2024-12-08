package com.leonardo.mvpagi.ms_customer.application.usecases.impl;

import com.leonardo.mvpagi.ms_customer.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_customer.application.usecases.DeleteCustomerByIdUseCase;
import com.leonardo.mvpagi.ms_customer.application.usecases.FindCustomerByIdUseCase;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.CustomValidationException;
import com.leonardo.mvpagi.ms_customer.domain.exceptions.NotFoundException;

import static java.util.Objects.isNull;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    private final CustomerGateway customerGateway;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    public DeleteCustomerByIdUseCaseImpl(CustomerGateway customerGateway, FindCustomerByIdUseCase findCustomerByIdUseCase) {
        this.customerGateway = customerGateway;
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
    }

    @Override
    public void execute(Long id) {
        if (isNull(id) || id < 0) throw CustomValidationException.of("Customer Id",
                "cannot be null or negative");
        final var customer = findCustomerByIdUseCase.execute(id);

        if (isNull(customer)) {
            throw NotFoundException.of("Customer");
        }
        customerGateway.delete(id);
    }
}
