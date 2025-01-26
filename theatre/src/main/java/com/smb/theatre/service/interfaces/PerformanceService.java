package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.Performance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PerformanceService {

    List<Performance> findAll ();

    Performance findById (Long id);

    void create (Performance performance);

    void update (Performance performance);

    void delete (Long id);
}
