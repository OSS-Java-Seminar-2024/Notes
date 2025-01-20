package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {

    Location createLocation(Location location);

    Location getLocationById(Long id);

    Location deleteLocationById(Long id);

    List<Location> getAllLocations();
}
