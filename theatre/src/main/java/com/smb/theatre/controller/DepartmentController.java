package com.smb.theatre.controller;

import com.smb.theatre.entity.Department;
import com.smb.theatre.entity.Project;
import com.smb.theatre.service.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Void> getDepartments (@PathVariable Long id) {
        Department department = departmentService.findById(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PostMapping("/departments")
    public ResponseEntity<Project> saveDepartment (@RequestBody Department department) {
        departmentService.create(department);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Void> updateDepartment (@PathVariable Long id, @RequestBody Department department) {

        Department updatedDepartment = departmentService.findById(id);

        updatedDepartment.setName(department.getName());

        departmentService.update(department);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDepartmentById (@PathVariable Long id) {
        Department department = departmentService.findById(id);

        departmentService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
