package com.leonardo.mvpagi.ms_customer.infra.persistence.repositories;

import com.leonardo.mvpagi.ms_customer.infra.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
