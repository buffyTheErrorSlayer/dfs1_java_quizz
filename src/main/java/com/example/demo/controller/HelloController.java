package com.example.demo.controller;

import com.example.demo.security.AppUserDetails;
import com.example.demo.security.IsAdmin;
import com.example.demo.security.IsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/")
    public String hello(){
        return "Hello";
    }

    @IsUser
    @GetMapping("/hello-user")
    public String helloUser(@AuthenticationPrincipal AppUserDetails userDetails){
        return "Hello " + userDetails.getUsername();
    }

    @IsAdmin
    @GetMapping("/hello-admin")
    public String helloAdmin(){
        return "Hello admin";
    }
}
