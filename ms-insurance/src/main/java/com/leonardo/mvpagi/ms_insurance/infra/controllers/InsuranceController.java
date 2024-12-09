package com.leonardo.mvpagi.ms_insurance.infra.controllers;

import com.leonardo.mvpagi.ms_insurance.application.usecases.*;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;
import com.leonardo.mvpagi.ms_insurance.infra.controllers.dtos.InsuranceDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/insurances")
public class InsuranceController {

    private final ModelMapper modelMapper;
    private final CreateInsuranceUseCase createInsuranceUseCase;
    private final FindInsuranceByIdUseCase findInsuranceByIdUseCase;
    private final FindInsuranceByCustomerIdUseCase findInsuranceByCustomerIdUseCase;
    private final FindAllInsurancesUseCase findAllInsurancesUseCase;
    private final DeleteInsuranceUseCase deleteInsuranceUseCase;

    public InsuranceController(ModelMapper modelMapper, CreateInsuranceUseCase createInsuranceUseCase, FindInsuranceByIdUseCase findInsuranceByIdUseCase, FindInsuranceByCustomerIdUseCase findInsuranceByCustomerIdUseCase, FindAllInsurancesUseCase findAllInsurancesUseCase, DeleteInsuranceUseCase deleteInsuranceUseCase) {
        this.modelMapper = modelMapper;
        this.createInsuranceUseCase = createInsuranceUseCase;
        this.findInsuranceByIdUseCase = findInsuranceByIdUseCase;
        this.findInsuranceByCustomerIdUseCase = findInsuranceByCustomerIdUseCase;
        this.findAllInsurancesUseCase = findAllInsurancesUseCase;
        this.deleteInsuranceUseCase = deleteInsuranceUseCase;
    }

    @GetMapping
    public ResponseEntity<List<InsuranceDto>> findAllInsurances() {
        var insurances = findAllInsurancesUseCase.findAllInsurances();
        return ResponseEntity.ok().body(insurances.stream().map(insurance -> modelMapper.map(insurance, InsuranceDto.class)).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceDto> findInsuranceById(@PathVariable Long id) {
        var insurance = findInsuranceByIdUseCase.findInsuranceById(id);
        return ResponseEntity.ok(modelMapper.map(insurance, InsuranceDto.class));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<InsuranceDto> findInsuranceByCustomerId(@PathVariable Long customerId) {
        var insurance = findInsuranceByCustomerIdUseCase.findInsuranceByCustomerId(customerId);
        return ResponseEntity.ok(modelMapper.map(insurance, InsuranceDto.class));
    }

    @PostMapping
    public ResponseEntity<InsuranceDto> createInsurance(@RequestBody InsuranceDto insuranceDto) {
        var request = modelMapper.map(insuranceDto, InsuranceDomain.class);
        request = createInsuranceUseCase.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(request, InsuranceDto.class));
    }

    @DeleteMapping("/{id}")
    public void deleteInsurance(@PathVariable Long id) {
        deleteInsuranceUseCase.deleteInsurance(id);
    }

}
