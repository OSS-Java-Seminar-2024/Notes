package com.smb.theatre.service;

import com.smb.theatre.entity.Project;
import com.smb.theatre.exception.EmployeeNotFound;
import com.smb.theatre.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProjectById(Long id) {
        return (Project) projectRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFound("Project with id " + id + " not found."));
    }

    // ovdje je potrebno popraviti return vrijednost (pogledaj ProjectControler)
    public Project deleteProjectById(Long id) {
        projectRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFound("Project with ID " + id + " not found"));
        projectRepository.deleteById(id);
        return null;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
