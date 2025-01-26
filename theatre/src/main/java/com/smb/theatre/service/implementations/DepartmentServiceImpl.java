package com.smb.theatre.service.implementations;

import com.smb.theatre.entity.Department;
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
    public List<Department> findAll () {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById (Long id) {
        return departmentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Department with the given id does not exist."));
    }

    @Override
    @Transactional
    public void create (Department department) {
        departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void update (Department department) {
        departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        departmentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Performance with the given id not found"));
        departmentRepository.deleteById(id);
    }
}
