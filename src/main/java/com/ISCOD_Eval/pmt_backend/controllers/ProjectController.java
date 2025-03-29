package com.ISCOD_Eval.pmt_backend.controllers;

import com.ISCOD_Eval.pmt_backend.models.Project;
import com.ISCOD_Eval.pmt_backend.models.User;
import com.ISCOD_Eval.pmt_backend.repositories.ProjectRepository;
import com.ISCOD_Eval.pmt_backend.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectController(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody ProjectRequest request) {
        Optional<User> owner = userRepository.findById(request.getOwnerId());
        if (owner.isEmpty()) {
            return ResponseEntity.badRequest().body("Owner not found with ID: " + request.getOwnerId());
        }

        Project project = new Project(request.getName(), request.getDescription(), request.getStartDate(), owner.get());
        Project savedProject = projectRepository.save(project);
        return ResponseEntity.ok(savedProject);
    }
}
