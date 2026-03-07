package in.cg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.cg.dto.UserDto;
import in.cg.services.UserService;

@RestController
public class MyController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto dto) {
        return userService.registerUser(dto);
    }

    @GetMapping("/user/profile")
    public String userProfile() {
        return "Welcome to the Profile Page";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Welcome to the Dashboard";
    }
}