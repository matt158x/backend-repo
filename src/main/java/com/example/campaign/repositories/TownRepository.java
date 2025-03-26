package com.example.campaign.repositories;

import com.example.campaign.models.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TownRepository extends JpaRepository<Town, Long> {
    List<Town> findByNameContainingIgnoreCaseOrderByName(String name);
    List<Town> findAllByOrderByNameAsc();
}