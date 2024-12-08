package com.leonardo.mvpagi.ms_customer.infra.controllers;

import com.leonardo.mvpagi.ms_customer.application.usecases.*;
import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;
import com.leonardo.mvpagi.ms_customer.infra.controllers.dtos.CustomerDto;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final ModelMapper modelMapper;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;
    private final FindAllCustomersUseCase findAllCustomersUseCase;
    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase, ModelMapper modelMapper, FindCustomerByIdUseCase findCustomerByIdUseCase, FindCustomerByCpfUseCase findCustomerByCpfUseCase, FindAllCustomersUseCase findAllCustomersUseCase, DeleteCustomerByIdUseCase deleteCustomerByIdUseCase, UpdateCustomerUseCase updateCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.modelMapper = modelMapper;
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findCustomerByCpfUseCase = findCustomerByCpfUseCase;
        this.findAllCustomersUseCase = findAllCustomersUseCase;
        this.deleteCustomerByIdUseCase = deleteCustomerByIdUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        var customer = findCustomerByIdUseCase.execute(id);
        return ResponseEntity.ok(modelMapper.map(customer, CustomerDto.class));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<CustomerDto> getCustomerByCpf(@PathVariable String cpf) {
        var customer = findCustomerByCpfUseCase.execute(cpf);
        return ResponseEntity.ok(modelMapper.map(customer, CustomerDto.class));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        var customers = findAllCustomersUseCase.execute();
        return ResponseEntity.ok().body(customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class)).toList());
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        var request = modelMapper.map(customerDto, CustomerDomain.class);
        request = createCustomerUseCase.execute(request);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(modelMapper.map(request, CustomerDto.class));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        deleteCustomerByIdUseCase.execute(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDto customerDto) {
        var request = modelMapper.map(customerDto, CustomerDomain.class);
        updateCustomerUseCase.update(id, request);
    }

}
