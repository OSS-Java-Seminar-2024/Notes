package com.smb.theatre.service.implementations;

import com.smb.theatre.entity.Performance;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.repository.PerformanceRepository;
import com.smb.theatre.service.interfaces.PerformanceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Override
    public List<Performance> findAll () {
        return performanceRepository.findAll();
    }

    @Override
    public Performance findById (Long id) {
        return performanceRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Performance with the given id does not exist."));
    }

    @Override
    @Transactional
    public void create (Performance performance) {
        performanceRepository.save(performance);
    }

    @Override
    @Transactional
    public void update (Performance performance) {
        performanceRepository.save(performance);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        performanceRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Performance with the given id not found"));
        performanceRepository.deleteById(id);
    }
}
