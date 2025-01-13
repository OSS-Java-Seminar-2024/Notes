package com.smb.theatre.service;

import com.smb.theatre.entity.Department;
import com.smb.theatre.exception.EmployeeNotFoundException;
import com.smb.theatre.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Department with id " + id + " not found."));
    }

    public void deleteById(Long id) {
        departmentRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Performance with ID " + id + " not found"));
        departmentRepository.deleteById(id);
    }

    public List<Department> getAllProjects() {
        return departmentRepository.findAll();
    }
}
