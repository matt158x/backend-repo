package com.example.campaign.controllers;

import com.example.campaign.models.Town;
import com.example.campaign.repositories.TownRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/towns")
@CrossOrigin(origins = "http://localhost:3000")
public class TownController {

    private final TownRepository townRepository;

    public TownController(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @GetMapping
    public ResponseEntity<List<Town>> getTowns(
            @RequestParam(required = false) String search) {

        if (search != null && !search.isEmpty()) {
            return ResponseEntity.ok(
                    townRepository.findByNameContainingIgnoreCaseOrderByName(search)
            );
        }
        return ResponseEntity.ok(
                townRepository.findAllByOrderByNameAsc()
        );
    }
}