package com.abcd.jwtimplimentation.service;

import com.abcd.jwtimplimentation.dto.JwtResponse;
import com.abcd.jwtimplimentation.dto.LoginRequest;
import com.abcd.jwtimplimentation.dto.RegisterRequest;
import com.abcd.jwtimplimentation.entity.User;
import com.abcd.jwtimplimentation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final CustomUserDetailsService customUserDetailsService;

    // Register User
    public String register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {

            throw new RuntimeException("Username already exists.");

        }

        User user = User.builder()

                .username(request.getUsername())

                .password(passwordEncoder.encode(request.getPassword()))

                .role(request.getRole())

                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // Login User
    public JwtResponse login(LoginRequest request) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getUsername(),

                        request.getPassword()

                )
        );

        UserDetails userDetails =

                customUserDetailsService.loadUserByUsername(

                        request.getUsername()

                );

        String token = jwtService.generateToken(userDetails);

        return JwtResponse.builder()

                .token(token)

                .username(userDetails.getUsername())

                .role(userDetails.getAuthorities().iterator().next().getAuthority())

                .build();

    }

}