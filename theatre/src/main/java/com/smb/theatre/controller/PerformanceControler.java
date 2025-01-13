package com.smb.theatre.controller;

import com.smb.theatre.entity.Performance;
import com.smb.theatre.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/performances")
public class PerformanceControler {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping
    public Performance createPerformance(@RequestBody Performance performance) {
        return performanceService.createPerformance(performance);
    }

    @GetMapping("/{id}")
    public Performance getPerformance(@PathVariable Long id) {
        return performanceService.getPerformance(id);
    }
}
