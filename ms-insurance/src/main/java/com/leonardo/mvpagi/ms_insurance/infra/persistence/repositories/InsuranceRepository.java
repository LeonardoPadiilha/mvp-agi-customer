package com.leonardo.mvpagi.ms_insurance.infra.persistence.repositories;

import com.leonardo.mvpagi.ms_insurance.infra.persistence.entities.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
}
