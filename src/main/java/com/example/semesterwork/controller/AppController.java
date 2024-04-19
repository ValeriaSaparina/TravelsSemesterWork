package com.example.semesterwork.controller;

import com.example.semesterwork.dto.UserDto;
import com.example.semesterwork.entity.UserEntity;
import com.example.semesterwork.service.user.UserService;
import com.example.semesterwork.service.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class AppController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/welcome")
    public String welcome() {
        return "This is welcome page";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userService.addUser(userEntity);
        return "in signUp";
    }

}
