package com.example.cw_spring.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    boolean isValidateToken(String token, UserDetails userDetails);
}
