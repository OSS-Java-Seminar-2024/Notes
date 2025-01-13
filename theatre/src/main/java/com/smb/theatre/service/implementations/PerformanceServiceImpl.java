package com.smb.theatre.service.implementations;

import com.smb.theatre.entity.Performance;
import com.smb.theatre.exception.EmployeeNotFound;
import com.smb.theatre.repository.PerformanceRepository;
import com.smb.theatre.service.interfaces.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    public Performance createPerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    public Performance getPerformanceById(Long id) {
        return performanceRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFound("Performance with id " + id + " not found."));
    }

    // ovdje je potrebno popraviti return vrijednost (pogledaj PerformancesControler)
    public Performance deletePerformanceById(Long id) {
        performanceRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFound("Performance with ID " + id + " not found"));
        performanceRepository.deleteById(id);
        return null;
    }

    public List<Performance> getAllPerformances() {
        return performanceRepository.findAll();
    }
}
