package com.leonardo.mvpagi.ms_insurance.infra.gateways;

import com.leonardo.mvpagi.ms_insurance.application.gateways.InsuranceGateway;
import com.leonardo.mvpagi.ms_insurance.domain.entities.InsuranceDomain;
import com.leonardo.mvpagi.ms_insurance.infra.persistence.entities.InsuranceEntity;
import com.leonardo.mvpagi.ms_insurance.infra.persistence.repositories.InsuranceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InsuranceRepositoryGateway implements InsuranceGateway {

    private final InsuranceRepository insuranceRepository;
    private final ModelMapper modelMapper;

    public InsuranceRepositoryGateway(InsuranceRepository insuranceRepository, ModelMapper modelMapper) {
        this.insuranceRepository = insuranceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public InsuranceDomain create(InsuranceDomain insuranceDomain) {
        final var entity = modelMapper.map(insuranceDomain, InsuranceEntity.class);
        insuranceRepository.save(entity);
        return modelMapper.map(entity, InsuranceDomain.class);
    }

    @Override
    public List<InsuranceDomain> findAllInsurances() {
        return List.of();
    }

    @Override
    public Optional<InsuranceDomain> findInsuranceById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<InsuranceDomain> findInsuranceByCustomerId(Long customerId) {
        return Optional.empty();
    }

    @Override
    public void updateInsurance(InsuranceDomain insuranceDomain) {

    }

    @Override
    public void deleteInsurance(Long id) {

    }
}
