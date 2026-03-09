package in.cg.main.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import in.cg.main.dto.UserDto;
import in.cg.main.services.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto dto) {
        return userService.registerUser(dto);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/profile")
    public String userProfile() {
        return "Welcome to profile page";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Welcome to admin dashboard";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/admin/users/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}