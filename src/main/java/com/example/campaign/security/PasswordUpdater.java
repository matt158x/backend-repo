package com.example.campaign.security;

import com.example.campaign.models.Users;
import com.example.campaign.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component
public class PasswordUpdater implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public PasswordUpdater(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running PasswordUpdater...");
        Users adminUser = userRepository.findByUsername("admin");
        if (adminUser != null) {
            if (!adminUser.getPassword().startsWith("{bcrypt}")) {
                String hashedPassword = passwordEncoder.encode("admin123");
                adminUser.setPassword(hashedPassword);
                userRepository.save(adminUser);
                System.out.println("Updated password for admin.");
            } else {
                System.out.println("Admin password is already hashed.");
            }
        } else {
            System.out.println("Admin user does not exist.");
        }
        Users user1 = userRepository.findByUsername("user1");
        if (user1 != null) {
            if (!user1.getPassword().startsWith("{bcrypt}")) {
                String hashedPassword = passwordEncoder.encode("pass1");
                user1.setPassword(hashedPassword);
                userRepository.save(user1);
                System.out.println("Updated password for user1.");
            } else {
                System.out.println("User1 password is already hashed.");
            }
        } else {
            System.out.println("User1 does not exist.");
        }
    }
}

