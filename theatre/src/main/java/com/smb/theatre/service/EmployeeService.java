package com.smb.theatre.service;

import com.smb.theatre.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long employeeId);

    void deleteEmployee(Long employeeId);
}
