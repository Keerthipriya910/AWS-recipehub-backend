package com.projectt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectt.Cryptography;
import com.projectt.entity.User;
import com.projectt.repo.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo repo;
    
    Cryptography cryp = new Cryptography();
    
    public String insertUser(User user) {
        repo.save(user);
        return "Registered Successfully! Login now!";
    }
    
    // Updated login method
    public User retrieveUser(User user) {
        try {
            User user2 = repo.findByUsername(user.getUsername());
            if (user2 != null) { // Check if the user exists in the database
                // Decrypt password and compare
                if (cryp.decryptData(user2.getPassword()).equals(user.getPassword())) {
                    return user2; // Return user if credentials are correct
                } else {
                    return null; // Return null on password mismatch
                }
            }
        } catch (Exception e) {
            // Log the exception (optional)
            System.out.println("Error during login: " + e.getMessage());
        }
        
        return null; // Return null if user not found or any error occurs
    }
}