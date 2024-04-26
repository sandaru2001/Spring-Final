package com.example.cw_spring.service;

import com.example.cw_spring.reqAndres.response.JwtAuthResponse;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn);
}
