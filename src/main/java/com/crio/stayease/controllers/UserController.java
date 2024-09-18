package com.crio.stayease.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.stayease.exchanges.LoginUserRequest;
import com.crio.stayease.exchanges.LoginUserResponse;
import com.crio.stayease.exchanges.RegisterUserRequest;
import com.crio.stayease.exchanges.RegisterUserResponse;
import com.crio.stayease.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(UserController.USER_API_ENDPOINT)
@RequiredArgsConstructor
public class UserController {
    
    public static final String USER_API_ENDPOINT = "/users";

    private final UserService userService;

    // post for registration
    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> registerUser(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
        RegisterUserResponse registerUserResponse = userService.registerUser(registerUserRequest);
        return ResponseEntity.ok().body(registerUserResponse);
    }

    // post - for login
    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> loginUser(@Valid @RequestBody LoginUserRequest loginUserRequest) {
        LoginUserResponse LoginUserResponse = userService.loginUser(loginUserRequest);
        return ResponseEntity.ok().body(LoginUserResponse);
    }
}
