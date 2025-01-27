package com.smb.theatre.service.implementations;

import com.smb.theatre.model.Department;
import com.smb.theatre.model.Project;
import com.smb.theatre.model.User;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.repository.DepartmentRepository;
import com.smb.theatre.repository.ProjectRepository;
import com.smb.theatre.repository.UserRepository;
import com.smb.theatre.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<User> findAll () {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new NotFoundException("No users found.");
        }

        return users;
    }

    @Override
    public User findById (Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("User with the given id does not exist."));
    }

    @Override
    public User create (User user) {

        // Retrieve the Department and Project from database based on their IDs
        Department department = null;
        Project project = null;

        if (user.getDepartment() != null && user.getDepartment().getId() != null) {
            department = departmentRepository.findById(user.getDepartment().getId())
                    .orElseThrow(() -> new NotFoundException("Department not found."));
        }

        if (user.getProject() != null && user.getProject().getId() != null) {
            project = projectRepository.findById(user.getProject().getId())
                    .orElseThrow(() -> new NotFoundException("Project not found."));
        }

        // Save Department and Project
        user.setDepartment(department);
        user.setProject(project);

        return userRepository.save(user);
    }

    @Override
    public User update (Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found."));

        existingUser = user;

        return userRepository.save(existingUser);
    }

    @Override
    public void delete (Long id) {
        userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("User with the given id not found."));
        userRepository.deleteById(id);
    }
}
