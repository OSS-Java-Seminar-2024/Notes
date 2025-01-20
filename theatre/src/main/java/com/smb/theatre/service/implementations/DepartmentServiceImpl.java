package com.smb.theatre.service.implementations;

import com.smb.theatre.model.Department;
import com.smb.theatre.exception.UserNotFoundException;
import com.smb.theatre.repository.DepartmentRepository;
import com.smb.theatre.service.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Department with id " + id + " not found."));
    }

    // ovdje je potrebno popraviti return vrijednost (pogledaj DepartmentController)
    public Department deleteDepartmentById(Long id) {
        departmentRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Performance with ID " + id + " not found"));
        departmentRepository.deleteById(id);
        return null;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
