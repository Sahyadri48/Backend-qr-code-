
package com.example.attendance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendance.service.InstituteService;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {
    private static final Logger log = LoggerFactory.getLogger(InstituteController.class);
    @Autowired
    private InstituteService instituteService;

    @GetMapping("/institute/id-lookup") 
    public ResponseEntity<Long> getInstituteId(@RequestParam String instituteName) {
        try {
            Long instituteId = instituteService.getInstituteId(instituteName);
            return ResponseEntity.ok(instituteId);
        } catch (Exception e) {
            log.error("Failed to fetch institute ID for {}: {}", instituteName, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}