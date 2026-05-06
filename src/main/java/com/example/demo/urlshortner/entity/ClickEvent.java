package com.example.demo.urlshortner.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CLICK_EVENT")
public class ClickEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "click_seq_gen")
    @SequenceGenerator(
            name = "click_seq_gen",
            sequenceName = "CLICK_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "SHORT_CODE")
    private String shortCode;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "USER_AGENT")
    private String userAgent;

    @Column(name = "CLICKED_AT")
    private LocalDateTime clickedAt = LocalDateTime.now();

    // Constructors
    public ClickEvent() {}

    public ClickEvent(String shortCode, String ipAddress, String userAgent) {
        this.shortCode = shortCode;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public LocalDateTime getClickedAt() {
        return clickedAt;
    }
}