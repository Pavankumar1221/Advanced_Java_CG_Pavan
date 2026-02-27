package com.springmvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @GetMapping("/home")
    public String openHomePage() {
        return "home";
    }

    @GetMapping("/login")
    public String openLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String openRegisterPage() {
        return "register";
    }
    @PostMapping("/profile")
    public String openProfile() {
        return "profile";
    }
}