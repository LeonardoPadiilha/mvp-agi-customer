package com.leonardo.mvpagi.ms_customer.controller;


import com.leonardo.mvpagi.ms_customer.application.usecases.*;
import com.leonardo.mvpagi.ms_customer.domain.CustomerDomain;
import com.leonardo.mvpagi.ms_customer.infra.controllers.CustomerController;
import com.leonardo.mvpagi.ms_customer.infra.controllers.dtos.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CreateCustomerUseCase createCustomerUseCase;
    @Mock
    private FindCustomerByIdUseCase findCustomerByIdUseCase;
    @Mock
    private FindCustomerByCpfUseCase findCustomerByCpfUseCase;
    @Mock
    private FindAllCustomersUseCase findAllCustomersUseCase;
    @Mock
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
    @Mock
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Mock
    private ModelMapper modelMapper;

    private CustomerDto customerDto;
    private CustomerDomain customerDomain;

    @BeforeEach
    void setUp() {
        customerDto = new CustomerDto();
        customerDto.setId(1L);
        customerDto.setName("Jose da Silva");
        customerDto.setCpf("12345678900");
        customerDto.setAddress("Rua das Palmeiras, 123");

        customerDomain = new CustomerDomain();
        customerDomain.setId(1L);
        customerDomain.setName("Jose da Silva");
        customerDomain.setCpf("12345678900");
        customerDomain.setAddress("Rua das Palmeiras, 123");
    }

    @Test
    void testGetCustomerById() {
        when(findCustomerByIdUseCase.execute(1L)).thenReturn(customerDomain);
        when(modelMapper.map(customerDomain, CustomerDto.class)).thenReturn(customerDto);

        ResponseEntity<CustomerDto> response = customerController.getCustomerById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Jose da Silva", response.getBody().getName());
    }

    @Test
    void testCreateCustomer() {
        when(createCustomerUseCase.execute(any(CustomerDomain.class))).thenReturn(customerDomain);
        when(modelMapper.map(customerDto, CustomerDomain.class)).thenReturn(customerDomain);
        when(modelMapper.map(customerDomain, CustomerDto.class)).thenReturn(customerDto);

        ResponseEntity<CustomerDto> response = customerController.createCustomer(customerDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Jose da Silva", response.getBody().getName());
    }

    @Test
    void testUpdateCustomer() {
        when(modelMapper.map(customerDto, CustomerDomain.class)).thenReturn(customerDomain);

        customerController.updateCustomer(1L, customerDto);

        verify(updateCustomerUseCase, times(1)).update(1L, customerDomain);
    }

    @Test
    void testDeleteCustomer() {
        doNothing().when(deleteCustomerByIdUseCase).execute(1L);

        customerController.deleteCustomer(1L);

        verify(deleteCustomerByIdUseCase, times(1)).execute(1L);
    }

    @Test
    void testGetCustomerByCpf() {
        when(findCustomerByCpfUseCase.execute("12345678900")).thenReturn(customerDomain);
        when(modelMapper.map(customerDomain, CustomerDto.class)).thenReturn(customerDto);

        ResponseEntity<CustomerDto> response = customerController.getCustomerByCpf("12345678900");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Jose da Silva", response.getBody().getName());
    }
}
