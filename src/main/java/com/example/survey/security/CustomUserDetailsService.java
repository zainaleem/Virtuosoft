package com.example.survey.security;

import com.example.survey.model.User;
import com.example.survey.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
//            com.backend.blogging.models.User user = userRepo.findByUsername(username);
            User user = userRepo.findByUsername(username);
//            return new User(user.getUsername(),user.getPassword(), new ArrayList<>());
            return user;
        }
        catch (Exception e) {
            logger.info("Exception in loadUserByUsername :{}",e);
            throw new RuntimeException("exception in loadUserByUsername");
        }
    }
}