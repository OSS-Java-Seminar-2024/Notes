package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.Project;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    Project getProjectById(Long id);

    Project deleteProjectById(Long id);

    List<Project> getAllProjects();
}
