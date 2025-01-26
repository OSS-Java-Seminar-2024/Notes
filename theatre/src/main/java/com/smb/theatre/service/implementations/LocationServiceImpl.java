package com.smb.theatre.service.implementations;

import com.smb.theatre.entity.Location;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.repository.LocationRepository;
import com.smb.theatre.service.interfaces.LocationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> findAll () {
        return locationRepository.findAll();
    }

    @Override
    public Location findById (Long id) {
        return locationRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Location with the given id does not exist."));
    }

    @Override
    @Transactional
    public void create (Location location) {
        locationRepository.save(location);
    }

    @Override
    @Transactional
    public void update (Location location) {
        locationRepository.save(location);
    }

    @Override
    public void delete (Long id) {
        locationRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Location with the given id not found."));
        locationRepository.deleteById(id);
    }
}
