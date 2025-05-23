package com.yash.UserService.controller;

import com.yash.UserService.deserializer.UserInfoEvent;
import com.yash.UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/v1/getUser")
    public ResponseEntity<UserInfoEvent> getUser(@RequestParam String email) {
        try {
            UserInfoEvent user = userService.getUser(email);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/user/v1/createUpdate")
    public ResponseEntity<UserInfoEvent> createOrUpdateUser(@RequestBody UserInfoEvent userInfoEvent) {
        try {
            UserInfoEvent user = userService.createOrUpdateUser(userInfoEvent);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/health")
    public ResponseEntity<Boolean> healthCheck(){
        return ResponseEntity.ok(true);
    }
}
