package com.leonardo.mvpagi.ms_customer.infra.persistence.controllers;

import com.leonardo.mvpagi.ms_customer.application.usecases.CreateCustomerUseCase;
import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;
import com.leonardo.mvpagi.ms_customer.infra.persistence.controllers.dtos.CustomerDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final ModelMapper modelMapper;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase, ModelMapper modelMapper) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
        var request = modelMapper.map(customerDto, CustomerDomain.class);
        request = createCustomerUseCase.execute(request);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(modelMapper.map(request, CustomerDto.class));
    }

}
