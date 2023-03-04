package com.example.healthcaremanagementsystem.repositories;

import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Repository
public interface HealthCareProviderRepository extends JpaRepository<HealthCareProvider, Long> {

    Optional<HealthCareProvider> findById(Long id);
    Optional<HealthCareProvider> findByName(String name);
    Optional<HealthCareProvider> deleteHealthCareProviderById(Long id);


}
