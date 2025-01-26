package com.smb.theatre.service.implementations;

import com.smb.theatre.entity.Project;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.repository.ProjectRepository;
import com.smb.theatre.service.interfaces.ProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll () {
        return projectRepository.findAll();
    }

    @Override
    public Project findById (Long id) {
        return projectRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Project with the given id does not exist."));
    }

    @Override
    @Transactional
    public void create (Project project) {
        projectRepository.save(project);
    }

    @Override
    @Transactional
    public void update (Project project) {
        projectRepository.save(project);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        projectRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Project with the given id not found"));
        projectRepository.deleteById(id);
    }

}
