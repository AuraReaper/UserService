package com.yash.UserService.controller;

import com.yash.UserService.entities.UserInfoDto;
import com.yash.UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/user/v1/getUser")
    public ResponseEntity<UserInfoDto> getUser(@RequestBody UserInfoDto userInfoDto) {
        try {
            UserInfoDto user = userService.getUser(userInfoDto);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/user/v1/createOrUpdateUser")
    public ResponseEntity<UserInfoDto> createOrUpdateUser(@RequestBody UserInfoDto userInfoDto) {
        try {
            UserInfoDto user = userService.createOrUpdateUser(userInfoDto);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/health")
    public ResponseEntity<Boolean> healthCheck(){
        return ResponseEntity.ok(true);
    }
}
