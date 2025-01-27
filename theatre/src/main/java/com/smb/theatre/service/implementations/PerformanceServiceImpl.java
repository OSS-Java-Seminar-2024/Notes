package com.smb.theatre.service.implementations;

import com.smb.theatre.model.Performance;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.repository.PerformanceRepository;
import com.smb.theatre.service.interfaces.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Override
    public List<Performance> findAll () {
        List<Performance> performances = performanceRepository.findAll();

        if (performances.isEmpty()) {
            throw new NotFoundException("No performances found.");
        }

        return performances;
    }

    @Override
    public Performance findById (Long id) {
        return performanceRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Performance with the given id does not exist."));
    }

    @Override
    public Performance create (Performance performance) {
        return performanceRepository.save(performance);
    }

    @Override
    public void delete (Long id) {
        performanceRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Performance with the given id not found."));
        performanceRepository.deleteById(id);
    }
}
