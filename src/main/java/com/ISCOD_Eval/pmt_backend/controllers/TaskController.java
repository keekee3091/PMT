package com.ISCOD_Eval.pmt_backend.controllers;

import com.ISCOD_Eval.pmt_backend.models.Project;
import com.ISCOD_Eval.pmt_backend.models.Task;
import com.ISCOD_Eval.pmt_backend.repositories.ProjectRepository;
import com.ISCOD_Eval.pmt_backend.repositories.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskController(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskRequest request) {
        Optional<Project> project = projectRepository.findById(request.getProjectId());

        if (project.isEmpty()) {
            return ResponseEntity.badRequest().body("Project not found with ID: " + request.getProjectId());
        }

        Task task = new Task(request.getTitle(), request.getDescription(), request.getDueDate(), request.getPriority(), request.getStatus(), project.get());
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(savedTask);
    }
}
