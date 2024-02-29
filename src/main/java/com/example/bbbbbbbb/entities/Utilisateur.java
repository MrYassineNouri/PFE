package com.example.bbbbbbbb.entities;


import jakarta.persistence.*;
import com.example.bbbbbbbb.entities.Role;

@Entity
//@Table(name="UTILISATEUR")
public class Utilisateur{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String nom;
    protected String email;
    protected String password;

    public Utilisateur() {
    }

    public Utilisateur(long id, String nom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
