package com.ISCOD_Eval.pmt_backend.controllers;

public class ProjectRequest {
    private String name;
    private String description;
    private String startDate;
    private Long ownerId;

    // Constructors
    public ProjectRequest() {}

    public ProjectRequest(String name, String description, String startDate, Long ownerId) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.ownerId = ownerId;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getStartDate() { return startDate; }
    public Long getOwnerId() { return ownerId; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
