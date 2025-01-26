package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    List<Department> findAll ();

    Department findById (Long id);

    void create (Department department);

    void update (Department department);

    void delete (Long id);

}
