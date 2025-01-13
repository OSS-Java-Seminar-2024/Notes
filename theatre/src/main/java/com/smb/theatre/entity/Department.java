package com.smb.theatre.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;

    Department () {}

    @Override
    public String toString () {
        return "[name= " + name + "category= " + category + "]";
    }
}
