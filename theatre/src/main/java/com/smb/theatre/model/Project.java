package com.smb.theatre.model;

import com.smb.theatre.model.enums.ProjectStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Performance> performanceList;

    @OneToMany
    private List<User> userList;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime deletedAt;
}
