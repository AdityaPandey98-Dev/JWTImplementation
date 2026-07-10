package com.abcd.jwtimplimentation.controller;

import com.abcd.jwtimplimentation.dto.ApiResponse;
import com.abcd.jwtimplimentation.dto.JwtResponse;
import com.abcd.jwtimplimentation.dto.LoginRequest;
import com.abcd.jwtimplimentation.dto.RegisterRequest;
import com.abcd.jwtimplimentation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(
            @RequestBody RegisterRequest request) {

        String message = userService.register(request);

        ApiResponse response = new ApiResponse(
                true,
                message,
                null
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(
            @RequestBody LoginRequest request) {

        JwtResponse jwtResponse = userService.login(request);

        ApiResponse response = new ApiResponse(
                true,
                "Login Successful",
                jwtResponse
        );

        return ResponseEntity.ok(response);
    }

}