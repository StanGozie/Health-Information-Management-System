package com.example.healthcaremanagementsystem.repositories;

import com.example.healthcaremanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    Boolean existsByEmail(String email);
}
