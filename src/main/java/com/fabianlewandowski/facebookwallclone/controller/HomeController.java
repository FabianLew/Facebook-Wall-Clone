package com.fabianlewandowski.facebookwallclone.controller;

import com.fabianlewandowski.facebookwallclone.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public User currentUser(@AuthenticationPrincipal User user){
        return user;
    }


}
