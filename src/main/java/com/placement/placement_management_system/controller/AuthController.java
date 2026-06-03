package com.placement.placement_management_system.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.placement.placement_management_system.dto.LoginRequest;
import com.placement.placement_management_system.dto.RegisterRequest;
import com.placement.placement_management_system.entity.User;
import com.placement.placement_management_system.repository.UserRepository;
import com.placement.placement_management_system.security.JwtService;

@RestController
public class AuthController {

    private JwtService jwtService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AuthController(JwtService jwtService,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {
            return "Invalid username";
        }

          


        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return "Invalid password";
        }

        return jwtService.generateToken(user.getUsername());
    }

    @PostMapping("/auth/register")
public String register(@RequestBody RegisterRequest request) {

    User user = new User();

       if (userRepository.findByUsername(request.getUsername()).isPresent()) {
        return "Username already exists";
    }


    user.setUsername(request.getUsername());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole(request.getRole());

    userRepository.save(user);

    return "User registered successfully";
}

}
