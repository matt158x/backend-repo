package com.example.campaign.repositories;

import com.example.campaign.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    boolean existsByUsername(String username);
    List<Users> findByAdminFalse();
}