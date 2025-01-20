package com.smb.theatre.service.interfaces;

import com.smb.theatre.dto.UserDto;
import com.smb.theatre.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    void saveEmployee(UserDto userDto);

    User getEmployeeById(Long id);

    User deleteEmployeeById(Long id);

    User findByUsername(String username);

    User findUserByEmail(String email);

    List<User> findAllEmployees();

    User registerNewUserAccount(@Valid UserDto userDto);
}
