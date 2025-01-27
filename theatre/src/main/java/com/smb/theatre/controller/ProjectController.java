package com.smb.theatre.controller;

import com.smb.theatre.entity.Project;
import com.smb.theatre.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAll () {
        List<Project> projects = projectService.findAll();
        return new ResponseEntity<>(projects, HttpStatus.FOUND);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProject (@PathVariable Long id) {
        Project project = projectService.findById(id);
        return new ResponseEntity<>(project, HttpStatus.FOUND);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> saveProject (@RequestBody Project project) {
        projectService.create(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Void> updateProject (@PathVariable Long id, @RequestBody Project project) {

        Project updatedProject = projectService.findById(id);

        updatedProject.setName(project.getName());
        updatedProject.setStartDate(project.getStartDate());
        updatedProject.setType(project.getType());

        projectService.update(updatedProject);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProjectById (@PathVariable Long id) {
        Project project = projectService.findById(id);

        projectService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
