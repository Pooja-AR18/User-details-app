package com.userapp.controller;

import com.userapp.model.User;
import com.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE User
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> createUser(
            @RequestParam("userId") String userId,
            @RequestParam("username") String username,
            @RequestParam("dob") String dob,
            @RequestParam("age") int age,
            @RequestParam("gender") String gender,
            @RequestParam("languages") List<String> languages,
            @RequestParam(value = "document", required = false) MultipartFile document,
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam("permanentAddress") String permanentAddress,
            @RequestParam("residentialAddress") String residentialAddress
    ) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername(username);
        user.setDob(dob);
        user.setAge(age);
        user.setGender(gender);
        user.setLanguages(String.join(",", languages));
        user.setDocument(document != null ? document.getOriginalFilename() : null);
        user.setPhoto(photo != null ? photo.getOriginalFilename() : null);
        user.setPermanentAddress(permanentAddress);
        user.setResidentialAddress(residentialAddress);

        System.out.println("Saving user with photo: " + user.getPhoto());
        System.out.println("Saving user with document: " + user.getDocument());

        return ResponseEntity.ok(userService.saveUser(user));
    }

    // UPDATE User
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> updateUser(
            @RequestParam("userId") String userId,
            @RequestParam("username") String username,
            @RequestParam("dob") String dob,
            @RequestParam("age") int age,
            @RequestParam("gender") String gender,
            @RequestParam("languages") List<String> languages,
            @RequestParam(value = "document", required = false) MultipartFile document,
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam("permanentAddress") String permanentAddress,
            @RequestParam("residentialAddress") String residentialAddress
    ) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername(username);
        user.setDob(dob);
        user.setAge(age);
        user.setGender(gender);
        user.setLanguages(String.join(",", languages));
        user.setDocument(document != null ? document.getOriginalFilename() : null);
        user.setPhoto(photo != null ? photo.getOriginalFilename() : null);
        user.setPermanentAddress(permanentAddress);
        user.setResidentialAddress(residentialAddress);

        System.out.println("Updating user with photo: " + user.getPhoto());
        System.out.println("Updating user with document: " + user.getDocument());

        return ResponseEntity.ok(userService.saveUser(user));
    }

    // GET all users
    @GetMapping
    public List<User> getUsers() {

        return userService.getAllUsers();
    }

    // DELETE user by ID
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {

        userService.deleteUser(userId);
    }
}
