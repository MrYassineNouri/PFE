package com.example.bbbbbbbb.repository;

import com.example.bbbbbbbb.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {

}
