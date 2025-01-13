package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.Performance;

import java.util.List;

public interface PerformanceService {

    Performance createPerformance(Performance performance);

    Performance getPerformanceById(Long id);

    Performance deletePerformanceById(Long id);

    List<Performance> getAllPerformances();
}
