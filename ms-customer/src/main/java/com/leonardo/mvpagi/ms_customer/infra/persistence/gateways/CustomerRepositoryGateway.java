package com.leonardo.mvpagi.ms_customer.infra.persistence.gateways;

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
        return List.of();
    }

    @Override
    public Optional<CustomerDomain> findCustomerById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerDomain> findCustomerByCpf(String cpf) {
        return Optional.empty();
    }

    @Override
    public void update(CustomerDomain customer) {

    }

    @Override
    public void delete(Long id) {

    }
}
