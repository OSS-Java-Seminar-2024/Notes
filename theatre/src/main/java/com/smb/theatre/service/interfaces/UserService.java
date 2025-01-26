package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void create(User user);

    void update(User user);

    void delete(Long id);
}
