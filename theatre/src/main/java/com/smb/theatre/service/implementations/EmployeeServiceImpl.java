package com.smb.theatre.service.implementations;

import com.smb.theatre.entity.Employee;
import com.smb.theatre.exception.EmployeeNotFound;
import com.smb.theatre.repository.EmployeeRepository;
import com.smb.theatre.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFound("Employee with id " + id + " not found."));
    }

    // ovdje je potrebno popraviti return vrijednost (pogledaj EmployeeControler)
    public Employee deleteEmployeeById(Long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFound("Employee with ID " + id + " not found"));
        employeeRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Object> isEmployeePresent(Employee employee) {
        return List.of();
    }
}
