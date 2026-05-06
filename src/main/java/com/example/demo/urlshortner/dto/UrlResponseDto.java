package com.example.demo.urlshortner.dto;

public class UrlResponseDto {

    private String originalUrl;
    private String shortUrl;
    private String shortCode;

    private Long clickCount;

    // Constructors
    public UrlResponseDto() {}

    public UrlResponseDto(String originalUrl, String shortUrl, String shortCode, Long clickCount) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.shortCode = shortCode;
        this.clickCount = clickCount;
    }

    // Getters & Setters
    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }
}