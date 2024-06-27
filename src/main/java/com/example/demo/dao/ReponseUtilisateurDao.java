package com.example.demo.dao;

import com.example.demo.model.ReponsePossible;
import com.example.demo.model.ReponseUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseUtilisateurDao extends JpaRepository<ReponseUtilisateur, Integer> {

}
