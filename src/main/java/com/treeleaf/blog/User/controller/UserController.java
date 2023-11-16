package com.treeleaf.blog.User.controller;

import com.treeleaf.blog.User.User;
import com.treeleaf.blog.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private AuthenticationManager authenticationManager;


    @PostMapping("register")
    public void registerUser(@RequestBody User user) {

        userRepository.saveUser(user);
    }

//    @GetMapping("login")
//    public void loginUser(@RequestBody User userDetails) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                userDetails.getUserName(),
//                userDetails.getPassword()));
//    }
}
