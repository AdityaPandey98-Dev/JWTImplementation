package com.abcd.jwtimplimentation.service;

import com.abcd.jwtimplimentation.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final JwtUtil jwtUtil;

    public JwtService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Generate JWT
    public String generateToken(UserDetails userDetails) {
        return jwtUtil.generateToken(userDetails);
    }

    // Validate JWT
    public boolean validateToken(String token, UserDetails userDetails) {
        return jwtUtil.validateToken(token, userDetails);
    }

    // Extract Username
    public String extractUsername(String token) {
        return jwtUtil.extractUsername(token);
    }

    // Extract Expiration
    public Date extractExpiration(String token) {
        return jwtUtil.extractExpiration(token);
    }
}