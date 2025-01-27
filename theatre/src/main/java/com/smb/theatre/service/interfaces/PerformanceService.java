package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.Performance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PerformanceService {

    List<Performance> findAll ();

    Performance findById (Long id);

    Performance create (Performance performance);

    void delete (Long id);
}
