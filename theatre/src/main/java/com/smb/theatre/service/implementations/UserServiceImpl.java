package com.smb.theatre.service.implementations;

import com.smb.theatre.entity.User;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.repository.UserRepository;
import com.smb.theatre.service.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll () {
        return userRepository.findAll();
    }

    @Override
    public User findById (Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("User with the given id does not exist."));
    }

    @Override
    @Transactional
    public void create (User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update (User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("User with the given id not found."));
        userRepository.deleteById(id);
    }
}
