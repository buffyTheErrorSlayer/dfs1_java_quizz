package com.example.demo.controller;

import com.example.demo.dao.ReponsePossibleDao;
import com.example.demo.model.ReponsePossible;
import com.example.demo.security.AppUserDetails;
import com.example.demo.security.IsAdmin;
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
@RequestMapping("/reponse-possible")
public class ReponsePossibleController {

    @Autowired
    ReponsePossibleDao reponsePossibleDao;

    @IsAdmin
    @PostMapping("")
    public ResponseEntity<ReponsePossible> add(
            @RequestBody @Valid ReponsePossible reponsePossible,
            @AuthenticationPrincipal AppUserDetails userDetails)
    {
        reponsePossible.setId(null);
        reponsePossibleDao.save(reponsePossible);
        return new ResponseEntity<>(reponsePossible, HttpStatus.CREATED);

    }
}
