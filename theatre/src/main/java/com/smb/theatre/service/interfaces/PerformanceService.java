package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.Performance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PerformanceService {

    Performance createPerformance(Performance performance);

    Performance getPerformanceById(Long id);

    Performance deletePerformanceById(Long id);

    List<Performance> getAllPerformances();
}
