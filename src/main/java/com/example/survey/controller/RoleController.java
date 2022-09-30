package com.example.survey.controller;

import com.example.survey.model.Project;
import com.example.survey.model.Role;
import com.example.survey.model.User;
import com.example.survey.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }
}
