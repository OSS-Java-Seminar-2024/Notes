package com.smb.theatre.controller;

import com.smb.theatre.model.Project;
import com.smb.theatre.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Project> saveProject (@RequestBody Project Project) {
        Project project = projectService.create(Project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject (@PathVariable Long id,
                                                     @RequestBody Project Project)
    {
        Project updatedProject = projectService.update(id, Project);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProjectById (@PathVariable Long id) {
        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
