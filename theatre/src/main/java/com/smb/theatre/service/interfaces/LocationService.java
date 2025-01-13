package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.Location;

import java.util.List;

public interface LocationService {

    Location createLocation(Location location);

    Location getLocationById(Long id);

    Location deleteLocationById(Long id);

    List<Location> getAllLocations();
}
