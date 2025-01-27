package com.smb.theatre.controller;

import com.smb.theatre.model.Department;
import com.smb.theatre.service.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAll () {
        List<Department> departments = departmentService.findAll();
        return new ResponseEntity<>(departments, HttpStatus.FOUND);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartments (@PathVariable Long id) {
        Department department = departmentService.findById(id);
        return new ResponseEntity<>(department, HttpStatus.FOUND);
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment (@RequestBody Department department) {
        Department createdDepartment = departmentService.create(department);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteDepartmentById (@PathVariable Long id) {
        departmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
