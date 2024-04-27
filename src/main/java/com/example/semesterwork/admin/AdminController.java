package com.example.semesterwork.admin;

import com.example.semesterwork.user.UserService;
import com.example.semesterwork.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    private final UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> get() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/updBlock")
    public ResponseEntity<UserDto> blockUser(@RequestBody BlockRequest request) {
        return ResponseEntity.ok(userService.updBlockUser(request));
    }
}