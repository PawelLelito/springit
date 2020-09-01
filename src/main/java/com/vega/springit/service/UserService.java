package com.vega.springit.service;

import com.vega.springit.domain.Role;
import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {

        //Take password from the form and encode
        String secret = "{bcrypt}" + encoder.encode("password");
        user.setPassword(secret);
        //confirm password

        //assign role to this user
        user.addRole(roleService.findByName("ROLE_USER"));


        //send an activation code
        //disable the user


        //save user
        save(user);

        // return the user
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void sendActivationEmail(User user){


    }

    @Transactional
    public void saveUsers(User... users) {
        for(User user : users) {
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }
}