package com.example.authservice.controller;

import com.example.authservice.dto.AuthResponse;
import com.example.authservice.dto.LoginRequest;
import com.example.authservice.dto.RegisterRequest;
import com.example.authservice.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/test")
    public String testEndpoint(){
        return "auth service is up and running!";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest Request){
        return authService.registerUser(Request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {return authService.loginUser(request);}


}
