package com.smb.theatre.controller;

import com.smb.theatre.entity.Performance;
import com.smb.theatre.service.interfaces.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/performances")
public class PerformanceControler {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping
    public ResponseEntity<Performance> createPerformance(@RequestBody Performance performance) {
        Performance savedPerformance = performanceService.createPerformance(performance);
        return new ResponseEntity<>(savedPerformance, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Performance> getPerformance(@PathVariable Long id) {
        Performance performance = performanceService.getPerformanceById(id);
        return new ResponseEntity<>(performance, HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Performance> deletePerformance(@PathVariable Long id) {
        Performance performance = performanceService.deletePerformanceById(id);
        return new ResponseEntity<>(performance, HttpStatus.FOUND);
    }
}
