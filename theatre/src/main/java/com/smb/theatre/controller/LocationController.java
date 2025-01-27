package com.smb.theatre.controller;

import com.smb.theatre.model.Location;
import com.smb.theatre.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAll () {
        List<Location> locations = locationService.findAll();
        return new ResponseEntity<>(locations, HttpStatus.FOUND);
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocation (@PathVariable Long id) {
        Location location = locationService.findById(id);
        return new ResponseEntity<>(location, HttpStatus.FOUND);
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> saveLocation (@RequestBody Location Location) {
        Location createdLocation = locationService.create(Location);
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Void> deleteLocationById (@PathVariable Long id) {
        locationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
