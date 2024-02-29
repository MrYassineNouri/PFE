package com.example.bbbbbbbb.controllers;

import com.example.bbbbbbbb.Services.UserService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/aff")
    @PermitAll
    public String aff() {
        return userService.aff();
    }

    @GetMapping("/auth")
    //@PermitAll
    public String auth() throws SQLException, IOException, ClassNotFoundException {
        return userService.authentification();
    }
}