package com.example.survey.controller;

import com.example.survey.model.Task;
import com.example.survey.model.User;
import com.example.survey.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    TaskRepo taskRepository;

    @GetMapping("/tasks")
    public List<Task> getTask() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{projectId}")
    public List<Task> getAllTasksByProjectId(@PathVariable Long projectId) {
        return taskRepository.findAllByProjectId(projectId);
    }

    @GetMapping("/tasks/username")
    public List<Task> findAllByUsername(@RequestParam String username) {
        return taskRepository.findAllByUsername(username);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createUser(@RequestBody Task taskDetails) {

        taskDetails = taskRepository.save(taskDetails);
        return new ResponseEntity<Task>(taskDetails, HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task taskDetails) {
        Task updateTask = null;
        Optional<Task> taskOptional = taskRepository.findById(taskDetails.getId());

        if (taskOptional.isPresent()) {
            updateTask = taskOptional.get();
            updateTask.setName(taskDetails.getName());
            updateTask.setSubTasks(taskDetails.getSubTasks());
            taskRepository.save(updateTask);
        }
        return ResponseEntity.ok(updateTask);
    }

}
