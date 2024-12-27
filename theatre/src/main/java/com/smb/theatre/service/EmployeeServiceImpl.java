package com.smb.theatre.service;

import com.smb.theatre.exception.EmployeeNotFoundException;
import com.smb.theatre.model.Employee;
import com.smb.theatre.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with id " + id + " not found."));
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with ID " + id + " not found"));
        employeeRepository.deleteById(id);
    }
}
