package com.example.survey;

import com.example.survey.enums.AccessLevel;
import com.example.survey.model.Role;
import com.example.survey.model.User;
import com.example.survey.repository.RoleRepo;
import com.example.survey.repository.UserRepo;
import com.example.survey.utils.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SurveyApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepository;

	@Autowired
	private UserRepo userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {

//			// CREATING ROLES
//			Role adminRole = new Role();
//			adminRole.setId(AppConstant.ADMIN_ID);
//			adminRole.setAccessLevel(AccessLevel.ROLE_ADMIN);
//
//			Role userRole = new Role();
//			userRole.setId(AppConstant.USER_ID);
//			userRole.setAccessLevel(AccessLevel.ROLE_USER);
//
//			List<Role> roles = new ArrayList<>();
//			roles.add(adminRole);
//			roles.add(userRole);
//			roleRepository.saveAll(roles);

//			// PERSIST ADMIN USER
//			User user = new User();
//			user.setId(1l);
//			user.setUsername("system");
//			user.setPassword(passwordEncoder.encode("dexter456"));
//			user.setCreatedBy("system");
//			Role systemRole = new Role();
//			systemRole.setId(AppConstant.ADMIN_ID);
//			List<Role> systemRoles = new ArrayList<>();
//			systemRoles.add(systemRole);
//			user.setRoles(systemRoles);
//			userRepository.save(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
