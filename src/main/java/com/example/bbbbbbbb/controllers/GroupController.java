package com.example.bbbbbbbb.controllers;


import com.example.bbbbbbbb.Services.GroupService;
import com.example.bbbbbbbb.Services.GroupService;
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
@RequestMapping("/api/v1/groupes")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    @GetMapping("/list")
    @PermitAll
    public List<groupe> aff(){
        return groupService.listGroupes();
    }

    @GetMapping("/new")
    public String newGrp() throws SQLException, IOException {
        return groupService.newGroupe();
    }


    @GetMapping("/mod")
    public String modif() throws SQLException, ClassNotFoundException {
        return groupService.modif();
    }
}
