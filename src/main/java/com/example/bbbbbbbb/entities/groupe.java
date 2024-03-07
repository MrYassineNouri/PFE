    package com.example.bbbbbbbb.entities;

    import jakarta.persistence.*;

    @Entity
    public class groupe {

        @Id
        protected long id;
        protected String nom;
        public groupe() {
        }

        public groupe(long id, String nom) {
            this.id = id;
            this.nom = nom;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

    }
