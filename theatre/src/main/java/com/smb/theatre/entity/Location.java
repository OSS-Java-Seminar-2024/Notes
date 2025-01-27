package com.smb.theatre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "country")
    private String country;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "location")
    @JsonManagedReference("location-performance-reference")
    private List<Performance> performanceList;
}
