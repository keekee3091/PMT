package com.ISCOD_Eval.pmt_backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String startDate;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)  // ✅ Automatically deletes projects when owner is deleted
    private User owner;

    // ✅ Default constructor (required by JPA)
    public Project() {
    }

    // ✅ Constructor for new projects (without ID)
    public Project(String name, String description, String startDate, User owner) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.owner = owner;
    }

    // ✅ Constructor including ID (for testing & retrieval)
    public Project(Long id, String name, String description, String startDate, User owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.owner = owner;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
