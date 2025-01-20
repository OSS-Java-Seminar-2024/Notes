package com.smb.theatre.service.implementations;

import com.smb.theatre.dto.UserDto;
import com.smb.theatre.exception.UserAlreadyExistsException;
import com.smb.theatre.model.User;
import com.smb.theatre.exception.UserNotFoundException;
import com.smb.theatre.repository.UserRepository;
import com.smb.theatre.service.interfaces.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public IUserServiceImpl(UserRepository repository) {
        super();
        this.repository = repository;
    }

    // Registration process.
    @Override
    public void saveEmployee(UserDto userDto) {
        User user = new User(userDto.getFirstName(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getLastName());
        repository.save(userDto);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Employee with id " + id + " not found."));
    }

    // ovdje je potrebno popraviti return vrijednost (pogledaj EmployeeControler)
    public User deleteEmployeeById(Long id) {
        repository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Employee with ID " + id + " not found"));
        repository.deleteById(id);
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findAllEmployees() {
        return List.of();
    }

    @Override
    public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistsException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistsException("There is an account with that email address:"
                    + userDto.getEmail());
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(user.getEmail());

        return repository.save(user);
    }

    private boolean emailExists(String email) {
        return repository.finByEmail(email) != null;
    }
}
