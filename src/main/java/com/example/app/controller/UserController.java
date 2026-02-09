package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.entities.User;
import com.example.app.service.UserService;
import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/user/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   
    @GetMapping("/signup")
    public String signupPage() {
        return "SignUp";   
    }

    
    @PostMapping("/signup")
    public String signupSubmit(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String role) {

        User user = new User(username, password, email, role);
        boolean success = userService.userSignup(user);

        if (success) {
            return "redirect:/user/api/login";
        } else {
            return "redirect:/user/api/signup-fail";
        }
    }

    
    @GetMapping("/login")
    public String loginPage() {
        return "login";   
    }

    
    @PostMapping("/login")
    public String loginSubmit(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        boolean result = userService.userSignin(username, password, session);

        if (result) {
            return "redirect:/user/api/otp";
        } else {
            return "redirect:/user/api/login-fail";
        }
    }

    
    @GetMapping("/login-fail")
    public String loginFailPage() {
        return "loginfail";
    }

    
    @GetMapping("/signup-fail")
    public String signupFailPage() {
        return "invalidsignUp";
    }

    
    @GetMapping("/otp")
    public String otpPage() {
        return "verify";
    }
    @PostMapping("/verify")
    public String verifyOtp(
            @RequestParam int otp,
            HttpSession session) {

        boolean verified = userService.verifyOtp(otp, session);

        if (verified) {
            session.removeAttribute("otp");
            return "success";   
        } else {
            return "otp-fail";     
        }
    }
}