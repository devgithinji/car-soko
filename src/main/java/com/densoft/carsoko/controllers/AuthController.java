package com.densoft.carsoko.controllers;

import com.densoft.carsoko.dto.JwtResponse;
import com.densoft.carsoko.dto.LoginDto;
import com.densoft.carsoko.dto.SignUpDto;
import com.densoft.carsoko.model.User;
import com.densoft.carsoko.security.JWTUtils;
import com.densoft.carsoko.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JWTUtils jwtUtils;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, JWTUtils jwtUtils) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@Valid @RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(user.getEmail(), user.getName(), "Bearer " + jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto signUpDto) {
        userService.createUser(signUpDto);
        Map<String, String> response = new HashMap<>();
        response.put("message", "user registered successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
