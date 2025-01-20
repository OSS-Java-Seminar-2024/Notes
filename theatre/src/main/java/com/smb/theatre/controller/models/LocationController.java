package com.smb.theatre.controller.models;

import com.smb.theatre.model.Location;
import com.smb.theatre.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location savedLocation = locationService.createLocation(location);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        Location location = locationService.getLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable Long id) {
        Location location = locationService.deleteLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

}
