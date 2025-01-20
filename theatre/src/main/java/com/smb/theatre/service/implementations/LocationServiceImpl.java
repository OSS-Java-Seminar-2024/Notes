package com.smb.theatre.service.implementations;

import com.smb.theatre.model.Location;
import com.smb.theatre.exception.UserNotFoundException;
import com.smb.theatre.repository.LocationRepository;
import com.smb.theatre.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Location with id " + id + " not found."));
    }

    // ovdje je potrebno popraviti return vrijednost (pogledaj LocationControler)
    public Location deleteLocationById(Long id) {
        locationRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Location with ID " + id + " not found"));
        locationRepository.deleteById(id);
        return null;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
