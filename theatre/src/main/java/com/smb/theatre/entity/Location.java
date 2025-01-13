package com.smb.theatre.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String city;
    private String address;

    @OneToMany(mappedBy = "location")
    private List<Performance> performanceList;

    Location () {}

    @Override
    public String toString () {
        return "[country= " + country + "city= " + city + "address= " + address + "]";
    }
}
