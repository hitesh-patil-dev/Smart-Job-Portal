package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jobportal.entity.User;
import com.jobportal.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {

        userService.saveUser(user);

        return "login";
    }
    
    
    @PostMapping("/loginUser")
    public String loginUser(User user, HttpSession session) {

        User validUser = userService.loginUser(user.getEmail(), user.getPassword());

        if (validUser != null) {

            session.setAttribute("loggedUser", validUser);

            return "index";
        } else {
        	
        	session.setAttribute("error", "Invalid Email or Password");
            return "login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "login";
    }

}