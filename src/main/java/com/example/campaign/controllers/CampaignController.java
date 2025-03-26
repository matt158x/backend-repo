package com.example.campaign.controllers;

import com.example.campaign.models.Campaign;
import com.example.campaign.services.CampaignService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
@CrossOrigin(origins = "http://localhost:3000")
public class CampaignController {
    @Autowired
    private CampaignService service;

    @GetMapping
    public List<Campaign> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Campaign getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Campaign create(@Valid @RequestBody Campaign campaign, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(String.valueOf(result.getAllErrors()));
        }
        return service.save(campaign);
    }

    @PutMapping("/{id}")
    public Campaign update(@PathVariable Long id, @RequestBody Campaign campaign) {
        campaign.setId(id);
        return service.save(campaign);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}