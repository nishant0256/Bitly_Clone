package com.example.demo.urlshortner.dto;

import java.time.LocalDateTime;

public class StatsResponseDto {

    private String shortCode;
    private String originalUrl;

    private Long totalClicks;

    private LocalDateTime createdAt;

    // Constructors
    public StatsResponseDto() {}

    public StatsResponseDto(String shortCode, String originalUrl, Long totalClicks, LocalDateTime createdAt) {
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
        this.totalClicks = totalClicks;
        this.createdAt = createdAt;
    }

    // Getters & Setters
    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Long getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(Long totalClicks) {
        this.totalClicks = totalClicks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}