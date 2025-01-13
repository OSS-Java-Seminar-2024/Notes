package com.smb.theatre.service;

import com.smb.theatre.entity.Performance;
import com.smb.theatre.exception.EmployeeNotFoundException;
import com.smb.theatre.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    public Performance createPerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    public Performance getPerformance(Long id) {
        return performanceRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Performance with id " + id + " not found."));
    }

    public void deleteById(Long id) {
        performanceRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Performance with ID " + id + " not found"));
        performanceRepository.deleteById(id);
    }

    public List<Performance> getAllProjects() {
        return performanceRepository.findAll();
    }
}
