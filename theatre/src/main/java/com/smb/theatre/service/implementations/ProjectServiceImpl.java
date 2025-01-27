package com.smb.theatre.service.implementations;

import com.smb.theatre.model.Project;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.repository.ProjectRepository;
import com.smb.theatre.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll () {
        List<Project> projects = projectRepository.findAll();

        if (projects.isEmpty()) {
            throw new NotFoundException("No projects found.");
        }

        return projects;
    }

    @Override
    public Project findById (Long id) {
        return projectRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Project with the given id does not exist."));
    }

    @Override
    public Project create (Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project update (Long id, Project project) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found."));

        existingProject = project;

        return projectRepository.save(existingProject);
    }

    @Override
    public void delete (Long id) {
        projectRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Project with the given id not found."));
        projectRepository.deleteById(id);
    }
}
