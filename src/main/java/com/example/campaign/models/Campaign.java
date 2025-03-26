package com.example.campaign.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campaign name is mandatory")
    @Size(max = 100, message = "Name must be less than 100 characters")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "At least one keyword is required")
    @Column(nullable = false)
    private String keywords;

    @NotNull(message = "Bid amount is mandatory")
    @DecimalMin(value = "0.01", message = "Bid amount must be at least 0.01")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal bidAmount;

    @NotNull(message = "Campaign fund is mandatory")
    @DecimalMin(value = "0.00", message = "Fund cannot be negative")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal campaignFund;

    @NotNull(message = "Status is mandatory")
    @Column(nullable = false)
    private boolean status;

    @NotBlank(message = "Town selection is mandatory")
    @Column(nullable = false)
    private String town;

    @NotNull(message = "Radius is mandatory")
    @Min(value = 1, message = "Radius must be at least 1 km")
    @Column(nullable = false)
    private Integer radius;
}