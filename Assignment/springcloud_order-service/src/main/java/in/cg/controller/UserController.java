package in.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.cg.dto.UserDto;
import in.cg.entities.User;
import in.cg.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserDto dto) {

        String message = userService.addUser(dto);

        return message;
    }
    
    
    @GetMapping("/getuserorders")
    public List<User> getAllUsers(){
    	return userService.getUserOrder();
    }
    
    @GetMapping("/orders")
    public List<User> getOrders(){
    	return userService.getUserOrder();
    }
    
    
}