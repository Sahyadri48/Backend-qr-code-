package com.example.attendance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.attendance.repository.InstituteRepository;

@Service
public class InstituteService {
    private static final Logger log = LoggerFactory.getLogger(InstituteService.class);
    @Autowired
    private InstituteRepository instituteRepository;

    @Cacheable(value = "instituteIds", key = "#instituteName")
    public Long getInstituteId(String instituteName) {
        try {
            log.info("Fetching institute ID for: {}", instituteName);
            return instituteRepository.findByInstituteName(instituteName)
                    .map(institute -> institute.getId()) // Use lambda or method reference with correct method
                    .orElseThrow(() -> new RuntimeException("Institute not found: " + instituteName));
        } catch (Exception e) {
            log.error("Error fetching institute ID for {}: {}", instituteName, e.getMessage());
            throw e;
        }
    }
}