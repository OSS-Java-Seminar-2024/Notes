package com.smb.theatre.controller;

import com.smb.theatre.model.Performance;
import com.smb.theatre.service.interfaces.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping("/performances")
    public ResponseEntity<List<Performance>> getAll () {
        List<Performance> performances = performanceService.findAll();
        return new ResponseEntity<>(performances, HttpStatus.FOUND);
    }

    @GetMapping("/performances/{id}")
    public ResponseEntity<Performance> getPerformance (@PathVariable Long id) {
        Performance performance = performanceService.findById(id);
        return new ResponseEntity<>(performance, HttpStatus.FOUND);
    }

    @PostMapping("/performances")
    public ResponseEntity<Performance> savePerformance (@RequestBody Performance Performance) {
        Performance performance = performanceService.create(Performance);
        return new ResponseEntity<>(performance, HttpStatus.CREATED);
    }

    @DeleteMapping("/performances/{id}")
    public ResponseEntity<Void> deletePerformanceById (@PathVariable Long id) {
        performanceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
