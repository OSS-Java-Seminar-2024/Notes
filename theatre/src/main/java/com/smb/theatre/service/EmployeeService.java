package com.smb.theatre.service;

import com.smb.theatre.entity.Employee;
import com.smb.theatre.exception.EmployeeNotFoundException;
import com.smb.theatre.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with id " + id + " not found."));
    }

    public void deleteById(Long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with ID " + id + " not found"));
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
