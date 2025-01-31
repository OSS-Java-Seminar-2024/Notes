package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.User;
import com.smb.theatre.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser (UserDto user);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers ();

}
