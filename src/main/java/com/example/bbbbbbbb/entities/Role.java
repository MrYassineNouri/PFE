package com.example.bbbbbbbb.entities;

import jakarta.persistence.*;

@Entity
//@Table(name="ROLE")
public class Role {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String titre;
    protected String description;

    public Role(long id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    public Role() {

    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
