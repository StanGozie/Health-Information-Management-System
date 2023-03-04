package com.example.healthcaremanagementsystem.repositories;

import com.example.healthcaremanagementsystem.model.LabInvestigation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LabInvestigationRepository extends JpaRepository<LabInvestigation, Long> {

    Optional<LabInvestigation> findByIdAndUuid(Long id, String uuid);
}
