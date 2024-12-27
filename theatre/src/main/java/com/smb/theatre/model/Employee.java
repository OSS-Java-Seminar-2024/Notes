package com.smb.theatre.model;
import com.smb.theatre.model.enums.Specialization;
import com.smb.theatre.model.enums.Status;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.time.LocalDateTime;

@Entity
@Table (name = "employee")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private @Id Long id;
    @NotNull
    private Long department_id;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password_hash;
    @NotNull
    private String first_name;
    @NotNull
    private String last_name;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    Employee () { }

    public void setId (Long id) { this.id = id; }

    public Long getId () { return id; }

    public void setDepartment_id (Long department_id) { this.department_id = department_id; }

    public Long getDepartment_id () { return department_id; }

    public void setFirst_name (String first_name) { this.first_name = first_name; }

    public String getFirst_name () { return first_name; }

    public void setLast_name (String last_name) { this.last_name = last_name; }

    public String getLast_name () { return last_name; }

    // No getters and setters needed for enumerations.

    public void setCreated_at (LocalDateTime created_at) { this.created_at = created_at; }

    public LocalDateTime getCreated_at () { return created_at; }

    public void setUpdated_at (LocalDateTime updated_at) { this.updated_at = updated_at; }

    public LocalDateTime getUpdated_at () { return updated_at; }

    public void setDeleted_at (LocalDateTime deleted_at) { this.deleted_at = deleted_at; }

    public LocalDateTime getDeleted_at () { return deleted_at; }

    public void setUsername (String username) { this.username = username; }

    public String getUsername () { return username; }

    public void setEmail (String email) { this.email = email; }

    public String getEmail () { return email; }

    public void setPassword_hash (String password_hash) { this.password_hash = password_hash; }

    public String getPassword_hash () { return password_hash; }

    @Override
    public String toString () {
        return "[email=" + email + "username=" + username + "first_name=" + first_name + "last_name=" + last_name + "]";
    }
}