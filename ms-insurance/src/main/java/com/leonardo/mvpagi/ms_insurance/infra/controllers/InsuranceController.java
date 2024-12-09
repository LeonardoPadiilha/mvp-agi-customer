package com.leonardo.mvpagi.ms_insurance.infra.controllers;

import com.leonardo.mvpagi.ms_insurance.application.usecases.CreateInsuranceUseCase;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;
import com.leonardo.mvpagi.ms_insurance.infra.controllers.dtos.InsuranceDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/insurances")
public class InsuranceController {

    private final ModelMapper modelMapper;
    private final CreateInsuranceUseCase createInsuranceUseCase;

    public InsuranceController(ModelMapper modelMapper, CreateInsuranceUseCase createInsuranceUseCase) {
        this.modelMapper = modelMapper;
        this.createInsuranceUseCase = createInsuranceUseCase;
    }

    @PostMapping
    public ResponseEntity<InsuranceDto> createInsurance(@RequestBody InsuranceDto insuranceDto) {
        var request = modelMapper.map(insuranceDto, InsuranceDomain.class);
        request = createInsuranceUseCase.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(request, InsuranceDto.class));
    }

}
