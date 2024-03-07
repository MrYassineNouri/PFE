package com.example.bbbbbbbb.controllers;

import com.example.bbbbbbbb.Services.UserService;
import com.example.bbbbbbbb.entities.Utilisateur;
import com.example.bbbbbbbb.entities.groupe;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PermitAll


    @GetMapping("/auth")
    //@PermitAll
    public String auth() throws SQLException, IOException, ClassNotFoundException {
        return userService.authentification();
    }
    @GetMapping("/compte")
    //@PermitAll
    public String compte() throws SQLException, IOException{
        return userService.compte();
    }

    @GetMapping("/status")
    @PermitAll
    public String check() throws ClassNotFoundException, SQLException{
       return userService.check();
    }

    @GetMapping("/users")
    @PermitAll
    public List<Utilisateur> listUsers() {
        List<Utilisateur> users=userService.listUsers();
        return users;
    }

    @GetMapping("/update")
    @PermitAll
    public String update() throws ClassNotFoundException, SQLException{
        return userService.update();
    }

}