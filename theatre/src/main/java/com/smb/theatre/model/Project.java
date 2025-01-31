package com.smb.theatre.model;

import com.smb.theatre.model.enums.ProjectStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
    @Column
    private String type;
    @Column
    private String description;
    @Column
    private String userRole;
    @Column
    private LocalDateTime startDate;
    @Column
    private LocalDateTime completionDate;

    @OneToMany(mappedBy = "project")
    List<Performance> performances;

    @ManyToMany(mappedBy = "projects")
    List<User> users;
}
