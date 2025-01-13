package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee deleteEmployeeById(Long id);

    List<Object> isEmployeePresent(Employee employee);
}
