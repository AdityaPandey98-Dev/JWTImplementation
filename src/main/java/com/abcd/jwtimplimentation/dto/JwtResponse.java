package com.abcd.jwtimplimentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class JwtResponse {
    private String token;
    private String username;
    private String role;
}
