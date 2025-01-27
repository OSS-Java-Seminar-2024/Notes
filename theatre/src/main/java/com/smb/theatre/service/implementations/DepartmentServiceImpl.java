package com.smb.theatre.service.implementations;

import com.smb.theatre.model.Department;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.repository.DepartmentRepository;
import com.smb.theatre.service.interfaces.DepartmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public List<Department> findAll () {
        List<Department> departments = departmentRepository.findAll();

        if (departments.isEmpty()) {
            throw new NotFoundException("No departments found.");
        }

        return departments;
    }

    @Override
    public Department findById (Long id) {
        return departmentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Department with the given id does not exist."));
    }

    @Override
    public Department create (Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete (Long id) {
        departmentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Department with the given id not found."));
        departmentRepository.deleteById(id);
    }
}
