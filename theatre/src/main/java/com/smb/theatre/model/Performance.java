package com.smb.theatre.model;

import com.smb.theatre.model.enums.PerformanceType;
import com.smb.theatre.model.enums.PerformanceStatus;
import jakarta.persistence.*;
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

    private String description;
    private LocalDateTime dateTime;
    private Time duration;

    @Enumerated(EnumType.STRING)
    private PerformanceStatus performanceStatus;

    @Enumerated(EnumType.STRING)
    private PerformanceType performanceType;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Location location;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
