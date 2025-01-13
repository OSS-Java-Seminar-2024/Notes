package com.smb.theatre.service.implementations;

import com.smb.theatre.entity.Project;
import com.smb.theatre.exception.EmployeeNotFound;
import com.smb.theatre.repository.ProjectRepository;
import com.smb.theatre.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

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
