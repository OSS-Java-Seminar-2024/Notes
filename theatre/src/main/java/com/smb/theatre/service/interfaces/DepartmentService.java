package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    Department createDepartment(Department department);

    Department getDepartmentById(Long id);

    Department deleteDepartmentById(Long id);

    List<Department> getAllDepartments();
}
