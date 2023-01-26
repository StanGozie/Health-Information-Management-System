package com.example.healthcaremanagementsystem.repositories;

import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Repository
public interface HealthProviderRepository extends JpaRepository<HealthCareProvider, Long> {

    Optional<HealthCareProvider> findByEmail(String email);
    Optional<HealthCareProvider> findById(Long id);
    Optional<HealthCareProvider> deleteHealthCareProviderByName(String name);
}
