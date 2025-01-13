package com.smb.theatre.service;

import com.smb.theatre.entity.Location;
import com.smb.theatre.exception.EmployeeNotFound;
import com.smb.theatre.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location getLocation(Long id) {
        return locationRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFound("Location with id " + id + " not found."));
    }

    public void deleteById(Long id) {
        locationRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFound("Location with ID " + id + " not found"));
        locationRepository.deleteById(id);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
