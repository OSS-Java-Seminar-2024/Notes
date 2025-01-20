package com.smb.theatre.controller.models;

import com.smb.theatre.model.Department;
import com.smb.theatre.service.interfaces.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable Long id) {
        Department department = departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
