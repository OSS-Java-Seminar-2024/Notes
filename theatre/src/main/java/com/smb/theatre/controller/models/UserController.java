package com.smb.theatre.controller.models;

import com.smb.theatre.dto.UserDto;
import com.smb.theatre.service.interfaces.IUserService;
import com.smb.theatre.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class UserController {

    @Autowired
    private IUserService IUserService;

    private UserDetailsService userDetailsService;

    public UserController(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @PostMapping
    public ResponseEntity<User> createEmployee(@RequestBody UserDto userDto) {
        IUserService.saveEmployee(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getEmployee(@PathVariable Long id) {
        User user = IUserService.getEmployeeById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteEmployee(@PathVariable Long id) {
        User user = IUserService.deleteEmployeeById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
