package com.smb.theatre.entity;

import com.smb.theatre.entity.enums.ProjectStatus;
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
    private List<Employee> employeeList;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime deletedAt;
}
