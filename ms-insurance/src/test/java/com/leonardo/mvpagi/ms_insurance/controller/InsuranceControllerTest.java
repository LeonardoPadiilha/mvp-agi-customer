package com.leonardo.mvpagi.ms_insurance.controller;

import com.leonardo.mvpagi.ms_insurance.application.usecases.*;
import com.leonardo.mvpagi.ms_insurance.domain.entities.CustomerDomain;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;
import com.leonardo.mvpagi.ms_insurance.infra.client.dto.SimulationResponseDto;
import com.leonardo.mvpagi.ms_insurance.infra.controllers.InsuranceController;
import com.leonardo.mvpagi.ms_insurance.infra.controllers.dtos.CustomerDto;
import com.leonardo.mvpagi.ms_insurance.infra.controllers.dtos.InsuranceDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InsuranceControllerTest {
    @Mock
    private CreateInsuranceUseCase createInsuranceUseCase;

    @Mock
    private FindInsuranceByIdUseCase findInsuranceByIdUseCase;

    @Mock
    private FindInsuranceByCustomerIdUseCase findInsuranceByCustomerIdUseCase;

    @Mock
    private FindAllInsurancesUseCase findAllInsurancesUseCase;

    @Mock
    private DeleteInsuranceUseCase deleteInsuranceUseCase;

    @Mock
    private SimulateInsuranceUseCase simulateInsuranceUseCase;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private InsuranceController insuranceController;

    @Test
    void testFindAllInsurances() {
        // Arrange
        var insuranceDto = new InsuranceDto();
        List<InsuranceDomain> insuranceList = List.of(new InsuranceDomain());
        when(findAllInsurancesUseCase.findAllInsurances()).thenReturn(insuranceList);
        when(modelMapper.map(any(), eq(InsuranceDto.class))).thenReturn(insuranceDto);

        // Act
        ResponseEntity<List<InsuranceDto>> response = insuranceController.findAllInsurances();

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testFindInsuranceById() {
        // Arrange
        Long insuranceId = 1L;
        InsuranceDomain insuranceDomain = new InsuranceDomain();
        when(findInsuranceByIdUseCase.findInsuranceById(insuranceId)).thenReturn(insuranceDomain);
        when(modelMapper.map(insuranceDomain, InsuranceDto.class)).thenReturn(new InsuranceDto());

        // Act
        ResponseEntity<InsuranceDto> response = insuranceController.findInsuranceById(insuranceId);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testFindInsuranceByCustomerId() {
        // Arrange
        Long customerId = 1L;
        InsuranceDomain insuranceDomain = new InsuranceDomain();
        when(findInsuranceByCustomerIdUseCase.findInsuranceByCustomerId(customerId)).thenReturn(insuranceDomain);
        when(modelMapper.map(insuranceDomain, InsuranceDto.class)).thenReturn(new InsuranceDto());

        // Act
        ResponseEntity<InsuranceDto> response = insuranceController.findInsuranceByCustomerId(customerId);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testCreateInsurance() {
        // Arrange
        InsuranceDto insuranceDto = new InsuranceDto();
        InsuranceDomain insuranceDomain = new InsuranceDomain();
        when(modelMapper.map(insuranceDto, InsuranceDomain.class)).thenReturn(insuranceDomain);
        when(createInsuranceUseCase.create(insuranceDomain)).thenReturn(insuranceDomain);
        when(modelMapper.map(insuranceDomain, InsuranceDto.class)).thenReturn(insuranceDto);

        // Act
        ResponseEntity<InsuranceDto> response = insuranceController.createInsurance(insuranceDto);

        // Assert
        assertNotNull(response);
        assertEquals(201, response.getStatusCode().value());
    }

    @Test
    void testDeleteInsurance() {
        // Arrange
        Long insuranceId = 1L;

        // Act
        insuranceController.deleteInsurance(insuranceId);

        // Assert
        verify(deleteInsuranceUseCase, times(1)).deleteInsurance(insuranceId);
    }

}
