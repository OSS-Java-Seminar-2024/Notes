package com.smb.theatre.service;

import com.smb.theatre.entity.Project;
import com.smb.theatre.exception.EmployeeNotFoundException;
import com.smb.theatre.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProject(Long id) {
        return (Project) projectRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Project with id " + id + " not found."));
    }

    public void deleteById(Long id) {
        projectRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Project with ID " + id + " not found"));
        projectRepository.deleteById(id);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
