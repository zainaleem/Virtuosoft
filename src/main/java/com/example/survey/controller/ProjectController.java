package com.example.survey.controller;

import com.example.survey.model.Project;
import com.example.survey.model.Task;
import com.example.survey.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectRepo projectRepository;

    @GetMapping("/projects")
    public List<Project> getProjectName(){
        return projectRepository.findAll();

    }

    @GetMapping("/projects/users/username")
    public List<Project> getProjectsByUsername(@RequestParam String username){
        return projectRepository.findProjectsByUsername(username);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject (@RequestBody Project projectDetails){
        projectDetails = projectRepository.save(projectDetails);
        return new ResponseEntity<Project>(projectDetails, HttpStatus.OK);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project projectDetails){
        Project updateProject = null;
        Optional<Project> projectOptional = projectRepository.findById(projectDetails.getId());
        if(projectOptional.isPresent()){
            updateProject = projectOptional.get();

            updateProject.setName(projectDetails.getName());
            updateProject.setDescription(projectDetails.getDescription());
            projectRepository.save(updateProject);
        }

        return ResponseEntity.ok(updateProject);
    }
}
