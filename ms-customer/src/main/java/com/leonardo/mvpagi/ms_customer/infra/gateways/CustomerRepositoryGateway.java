package com.leonardo.mvpagi.ms_customer.infra.gateways;

import com.leonardo.mvpagi.ms_customer.application.gateways.CustomerGateway;
import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;
import com.leonardo.mvpagi.ms_customer.infra.persistence.entities.CustomerEntity;
import com.leonardo.mvpagi.ms_customer.infra.persistence.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class CustomerRepositoryGateway implements CustomerGateway {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerRepositoryGateway(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDomain create(CustomerDomain customer) {
        final var entity = modelMapper.map(customer, CustomerEntity.class);
        customerRepository.save(entity);
        return modelMapper.map(entity, CustomerDomain.class);
    }

    @Override
    public List<CustomerDomain> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(value -> modelMapper.map(value, CustomerDomain.class))
                .toList();
    }

    @Override
    public Optional<CustomerDomain> findCustomerById(Long id) {
        final var customer = customerRepository.findById(id);
        return customer.map(value -> modelMapper.map(value, CustomerDomain.class));
    }

    @Override
    public Optional<CustomerDomain> findCustomerByCpf(String cpf) {
        final var customer = customerRepository.findByCpf(cpf);
        return customer.map(value -> modelMapper.map(value, CustomerDomain.class));
    }

    @Override
    public void update(CustomerDomain customer) {
    final var entity = modelMapper.map(customer, CustomerEntity.class);
    customerRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
