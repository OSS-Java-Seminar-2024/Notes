package com.smb.theatre.service.interfaces;

import com.smb.theatre.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    List<Project> findAll ();

    Project findById (Long id);

    void create (Project project);

    void update (Project project);

    void delete (Long id);
}


