package com.smb.theatre.controller;

import com.smb.theatre.entity.Location;
import com.smb.theatre.entity.Performance;
import com.smb.theatre.entity.Project;
import com.smb.theatre.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Void> getLocation (@PathVariable Long id) {
        Location location = locationService.findById(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PostMapping("/locations")
    public ResponseEntity<Project> saveLocation (@RequestBody Location location) {
        locationService.create(location);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<Void> updateLocation (@PathVariable Long id, @RequestBody Location location) {

        Location updatedLocation = locationService.findById(id);

        updatedLocation.setAddress(location.getAddress());

        locationService.update(location);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLocationById (@PathVariable Long id) {
        Location location = locationService.findById(id);

        locationService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
