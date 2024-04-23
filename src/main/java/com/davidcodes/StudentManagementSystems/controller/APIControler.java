package com.davidcodes.StudentManagementSystems.controller;

import com.davidcodes.StudentManagementSystems.model.LoginUser;
import com.davidcodes.StudentManagementSystems.model.User;
import com.davidcodes.StudentManagementSystems.services.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class APIControler {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user){
        return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> signup(@RequestBody LoginUser user){
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody LoginUser user, @PathVariable String userId){
        return new ResponseEntity<>(userService.updateUser(user, userId), HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }

}
