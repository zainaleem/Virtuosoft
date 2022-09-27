package com.example.survey.controller;

import com.example.survey.model.Company;
import com.example.survey.model.User;
import com.example.survey.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

@Autowired
UserRepo userRepository;


    @GetMapping("/users")
    public List<User> getUserName() {
        return userRepository.findAll();
    }

    @GetMapping("/users/username")
    public User getUserByUsername(@RequestParam String username){ return userRepository.findByUsername(username); }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User userDetails) {
        userDetails.setImagePath(userDetails.getImagePath()!=null?userDetails.getImagePath():"profile.jpg");
        userDetails = userRepository.save(userDetails);
        return new ResponseEntity<User>(userDetails, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User userDetails) {
        User updateUser = null;
        Optional<User> userOptional = userRepository.findById(userDetails.getId());

        if (userOptional.isPresent()) {
            updateUser = userOptional.get();
            updateUser.setName(userDetails.getName());
            updateUser.setUsername(userDetails.getUsername());
            updateUser.setPassword(userDetails.getPassword());
            updateUser.setEmail(userDetails.getEmail());
            userRepository.save(updateUser);
        }
        return ResponseEntity.ok(updateUser);
    }


}
