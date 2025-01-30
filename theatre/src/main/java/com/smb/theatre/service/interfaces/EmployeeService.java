package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.Employee;
import com.smb.theatre.model.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee create(Employee employee);

    Employee update(Long id, Employee employee);

    void delete(Long id);

    // Employee registerNewEmployee (EmployeeDto employeeDto);
}
