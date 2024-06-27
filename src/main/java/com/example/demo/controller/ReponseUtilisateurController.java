package com.example.demo.controller;

import com.example.demo.dao.ReponseUtilisateurDao;
import com.example.demo.model.ReponseUtilisateur;
import com.example.demo.security.AppUserDetails;
import com.example.demo.security.IsAdmin;
import com.example.demo.security.IsUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reponse-utilisateur")
public class ReponseUtilisateurController {

    @Autowired
    ReponseUtilisateurDao reponseUtilisateurDao;

    @IsUser
    @PostMapping("")
    public ResponseEntity<ReponseUtilisateur> add(
            @RequestBody @Valid ReponseUtilisateur reponseUtilisateur,
            @AuthenticationPrincipal AppUserDetails userDetails)
    {
        reponseUtilisateur.setId(null);
        reponseUtilisateur.setUtilisateur(userDetails.getUtilisateur());
        reponseUtilisateurDao.save(reponseUtilisateur);
        return new ResponseEntity<>(reponseUtilisateur, HttpStatus.CREATED);

    }
}
