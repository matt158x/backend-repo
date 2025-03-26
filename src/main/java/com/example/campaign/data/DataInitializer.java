package com.example.campaign.data;

import com.example.campaign.models.Users;
import com.example.campaign.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            Users admin = new Users();
            admin.setUsername("admin");
            admin.setPassword("admin123");
            admin.setAccountBalance(new BigDecimal("1000.00"));
            admin.setAdmin(true);
            Users user = new Users();
            user.setUsername("user1");
            user.setPassword("pass1");
            user.setAccountBalance(new BigDecimal("500.00"));
            userRepository.saveAll(List.of(admin, user));
            System.out.println("Added test users to database");
        }
    }
}