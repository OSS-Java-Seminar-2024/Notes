package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {

    List<Location> findAll ();

    Location findById (Long id);

    Location create (Location location);

    void delete (Long id);

}
