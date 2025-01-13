package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    Department getDepartmentById(Long id);

    Department deleteDepartmentById(Long id);

    List<Department> getAllDepartments();
}
