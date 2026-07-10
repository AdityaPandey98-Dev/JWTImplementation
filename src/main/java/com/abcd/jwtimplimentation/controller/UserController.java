package com.abcd.jwtimplimentation.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/profile")
    public String profile() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return "Welcome "
                + authentication.getName()
                + " to User Profile";
    }

    @GetMapping("/user/dashboard")
    public String dashboard() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return "Welcome "
                + authentication.getName()
                + " to User Dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return "Welcome Admin "
                + authentication.getName();
    }

}