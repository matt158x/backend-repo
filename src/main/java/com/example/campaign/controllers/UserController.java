package com.example.campaign.controllers;

import com.example.campaign.models.Users;
import com.example.campaign.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/non-admins")
    public List<Users> getNonAdminUsers() {
        return userRepository.findByAdminFalse();
    }

    @PutMapping("/{id}/update-balance")
    public ResponseEntity<?> updateAccountBalance(
            @PathVariable Long id, @RequestBody Map<String, Double> requestBody) {

        if (!requestBody.containsKey("accountBalance")) {
            return ResponseEntity.badRequest().body("Account balance not provided.");
        }

        double newBalance = requestBody.get("accountBalance");

        Optional<Users> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Users user = userOpt.get();
        user.setAccountBalance(BigDecimal.valueOf(newBalance));

        userRepository.save(user);

        return ResponseEntity.ok("Account balance updated successfully.");
    }
}