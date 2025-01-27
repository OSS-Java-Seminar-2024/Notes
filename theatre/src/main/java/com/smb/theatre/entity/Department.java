package com.smb.theatre.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.smb.theatre.entity.enums.DepartmentCategory;
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

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private DepartmentCategory category;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference("department-user-reference")
    private List<User> userList;
}
