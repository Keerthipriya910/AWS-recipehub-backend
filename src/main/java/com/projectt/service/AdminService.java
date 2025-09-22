package com.projectt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectt.Cryptography;
import com.projectt.entity.Admin;
import com.projectt.repo.AdminRepo;

@Service
public class AdminService {
    
    @Autowired
    AdminRepo repo1;
    
    Cryptography cryp = new Cryptography();
    
    public String insertAdmin(Admin admin) {
        repo1.save(admin);
        return "Registered Successfully! Login now!";
    }
    
    // Updated login method
    public Admin retrieveAdmin(Admin admin) {
        try {
            Admin admin2 = repo1.findByUsername(admin.getUsername());
            if (admin2 != null) { // Check if the user exists in the database
                // Decrypt password and compare
                if (cryp.decryptData(admin2.getPassword()).equals(admin.getPassword())) {
                    return admin2; // Return user if credentials are correct
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