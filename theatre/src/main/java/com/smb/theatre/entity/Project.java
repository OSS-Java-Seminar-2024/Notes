package com.smb.theatre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.smb.theatre.entity.enums.ProjectStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @Column(name = "start_date", unique = true)
    private LocalDateTime startDate;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    LocalDateTime deletedAt;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference("project-performance-reference")
    private List<Performance> performanceList;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference("project-user-reference")
    private List<User> userList;
}
