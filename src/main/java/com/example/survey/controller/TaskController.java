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
            updateTask.setDescription(taskDetails.getDescription());
            updateTask.setParentId(taskDetails.getParentId());
            taskRepository.save(updateTask);
        }
        return ResponseEntity.ok(updateTask);
    }

}
