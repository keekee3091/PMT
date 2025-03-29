package com.ISCOD_Eval.pmt_backend.controllers;

public class TaskRequest {
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    private String status;
    private Long projectId;

    // Constructors
    public TaskRequest() {}

    public TaskRequest(String title, String description, String dueDate, String priority, String status, Long projectId) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.projectId = projectId;
    }

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDueDate() { return dueDate; }
    public String getPriority() { return priority; }
    public String getStatus() { return status; }
    public Long getProjectId() { return projectId; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setStatus(String status) { this.status = status; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
}
