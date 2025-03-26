package com.example.campaign.services;

import com.example.campaign.models.Campaign;
import com.example.campaign.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository repository;

    public List<Campaign> getAll() { return repository.findAll(); }
    public Campaign getById(Long id) { return repository.findById(id).orElse(null); }
    public Campaign save(Campaign campaign) { return repository.save(campaign); }
    public void delete(Long id) { repository.deleteById(id); }
}