package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    Project createProject(Project project);

    Project getProjectById(Long id);

    Project deleteProjectById(Long id);

    List<Project> getAllProjects();
}
