package com.example.bbbbbbbb.entities;


import jakarta.persistence.*;

@Entity
//@Table(name="UTILISATEUR")
public class Utilisateur{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String password;
    protected String numTel;

    public Utilisateur() {
    }

    public Utilisateur(long id, String nom,String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.prenom=prenom;
        this.numTel=numTel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNumTel() {
        return numTel;
    }
}