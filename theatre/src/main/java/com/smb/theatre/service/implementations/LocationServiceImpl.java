package com.smb.theatre.service.implementations;

import com.smb.theatre.model.Location;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.repository.LocationRepository;
import com.smb.theatre.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> findAll () {
        List<Location> locations = locationRepository.findAll();

        if (locations.isEmpty()) {
            throw new NotFoundException("No locations found.");
        }

        return locations;
    }

    @Override
    public Location findById (Long id) {
        return locationRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Location with the given id does not exist."));
    }

    @Override
    public Location create (Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void delete (Long id) {
        locationRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Location with the given id not found."));
        locationRepository.deleteById(id);
    }
}
