package com.example.attendance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendance.model.Institute;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Long> {
	Optional<Institute> findByInstituteName(String instituteName);
}
