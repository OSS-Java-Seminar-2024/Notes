package com.smb.theatre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.smb.theatre.entity.enums.PerformanceType;
import com.smb.theatre.entity.enums.PerformanceStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "performance")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PerformanceStatus status;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PerformanceType type;

    @Column(name = "description")
    private String description;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference("project-performance-reference")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonBackReference("location-performance-reference")
    private Location location;
}
