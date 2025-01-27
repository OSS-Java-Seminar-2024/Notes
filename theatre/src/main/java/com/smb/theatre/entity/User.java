package com.smb.theatre.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.smb.theatre.entity.enums.EmployeeStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table (name = "employee")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "mobile", unique = true)
    private String mobile;

    @NotNull
    @Column(name = "password_hash")
    private String passwordHash;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @ManyToOne
    @JsonBackReference("department-user-reference")
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JsonBackReference("project-user-reference")
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    User () {}
}