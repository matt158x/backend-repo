package com.example.campaign.repositories;

import com.example.campaign.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}