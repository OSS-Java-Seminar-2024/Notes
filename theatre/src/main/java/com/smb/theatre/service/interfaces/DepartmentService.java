package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    List<Department> findAll ();

    Department findById (Long id);

    Department create (Department department);

    void delete (Long id);

}
