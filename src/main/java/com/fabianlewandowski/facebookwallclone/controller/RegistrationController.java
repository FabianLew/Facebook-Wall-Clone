package com.fabianlewandowski.facebookwallclone.controller;

import com.fabianlewandowski.facebookwallclone.model.User;
import com.fabianlewandowski.facebookwallclone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user){
        boolean isUnique = true;
        List<User> users = userRepo.findAll();
        for (User us : users){
            if (Objects.equals(user.getUsername(), us.getUsername())) {
                isUnique = false;
                break;
            }
        }
        if(isUnique) {
            userRepo.save(user.encodedUser(passwordEncoder));
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
