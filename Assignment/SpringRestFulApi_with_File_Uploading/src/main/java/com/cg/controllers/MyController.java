package com.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import com.cg.entities.User;
import com.cg.services.FileStorageService;
import com.cg.services.UserService;

@RestController
public class MyController {

    @Autowired
    UserService us;

    @Autowired
    private FileStorageService fileStorageService;


    // ================= FILE UPLOAD =================

    @PostMapping(
            value = "/user/{id}/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<String> uploadFile(
            @PathVariable int id,
            @RequestParam("file") MultipartFile file) {

        String fileName = fileStorageService.storeFile(file);

        return ResponseEntity.ok("File uploaded successfully: " + fileName);
    }


    // ================= FILE DOWNLOAD =================

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {

        Resource resource = fileStorageService.loadFileAsResource(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    // ================= CREATE USER =================

    @PostMapping("/user")
    public User displayUser(@RequestBody User user) {
        return us.addUserDetails(user);
    }


    // ================= GET USERS =================

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return us.getAllUsers();
    }


    // ================= UPDATE USER =================

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return us.updateUser(id, user.getName());
    }


    // ================= DELETE USER =================

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {

        boolean status = us.deleteId(id);

        if (status) {
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }
}