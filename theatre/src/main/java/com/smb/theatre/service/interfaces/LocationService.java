package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {

    List<Location> findAll ();

    Location findById (Long id);

    void create (Location location);

    void update (Location location);

    void delete (Long id);

}
