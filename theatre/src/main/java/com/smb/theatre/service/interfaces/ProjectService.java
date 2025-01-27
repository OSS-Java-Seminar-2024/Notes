package com.smb.theatre.service.interfaces;

import com.smb.theatre.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    List<Project> findAll ();

    Project findById (Long id);

    Project create (Project Project);

    Project update (Long id, Project Project);

    void delete (Long id);
}


