package com.upiiz.grandesligas.controllers;

import com.upiiz.grandesligas.dto.AuthResponse;
import com.upiiz.grandesligas.models.Usuario;
import com.upiiz.grandesligas.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody Usuario request) {
        String token = authenticationService.register(request);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody Usuario request) {
        String token = authenticationService.authenticate(request);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}