package com.fabianlewandowski.facebookwallclone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationPageController {

    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "registrationPage";
    }

}
