package com.example.app.service;

import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.app.entities.User;
import com.example.app.repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final JavaMailSender mailSender;

    public UserService(UserRepo userRepo, JavaMailSender mailSender) {
        this.userRepo = userRepo;
        this.mailSender = mailSender;
    }

   
    public boolean userSignup(User user) {
        try {
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


	public boolean userSignin(String username, String password, HttpSession session) {
		User user = userRepo.findByUsername(username);

        if (user == null) return false;
        if (!user.getPassword().equals(password)) return false;

        int otp = new Random().nextInt(100000, 999999);
        System.out.println("Generated OTP: " + otp);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setSubject("Login OTP");
            message.setText("Your OTP is: " + otp);

            mailSender.send(message);

         
            session.setAttribute("otp", otp);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	public boolean verifyOtp(int otp, HttpSession session) {
		   Integer sessionOtp = (Integer) session.getAttribute("otp");

	        if (sessionOtp == null) {
	            return false;
	        }

	        return sessionOtp ==  otp;
	}

	
}