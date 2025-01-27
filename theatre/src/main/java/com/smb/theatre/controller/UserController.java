package com.smb.theatre.controller;

import com.smb.theatre.model.User;
import com.smb.theatre.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll () {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser (@RequestBody User User) {
        User user = userService.create(User);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser (@PathVariable Long id,
                                               @RequestBody User User)
    {
        User updatedUser = userService.update(id, User);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById (@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
