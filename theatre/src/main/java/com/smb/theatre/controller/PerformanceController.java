package com.smb.theatre.controller;

import com.smb.theatre.entity.Performance;
import com.smb.theatre.entity.Project;
import com.smb.theatre.service.interfaces.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Void> getPerformance (@PathVariable Long id) {
        Performance performance = performanceService.findById(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PostMapping("/performances")
    public ResponseEntity<Project> savePerformance (@RequestBody Performance performance) {
        performanceService.create(performance);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/performances/{id}")
    public ResponseEntity<Void> updatePerformance (@PathVariable Long id, @RequestBody Performance performance) {

        Performance updatedPerformance = performanceService.findById(id);

        updatedPerformance.setStatus(performance.getStatus());
        updatedPerformance.setType(performance.getType());
        updatedPerformance.setDescription(performance.getDescription());

        performanceService.update(performance);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/performances/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePerformanceById (@PathVariable Long id) {
        Performance performance = performanceService.findById(id);

        performanceService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
