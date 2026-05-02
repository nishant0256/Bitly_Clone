package entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "URL_MAPPING")
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_seq_gen")
    @SequenceGenerator(
            name = "url_seq_gen",
            sequenceName = "URL_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "ORIGINAL_URL", nullable = false, length = 2048)
    private String originalUrl;

    @Column(name = "SHORT_CODE", nullable = false, unique = true, length = 50)
    private String shortCode;

    @Column(name = "CLICK_COUNT")
    private Long clickCount = 0L;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "EXPIRY_DATE")
    private LocalDateTime expiryDate;

    // Constructors
    public UrlMapping() {}

    public UrlMapping(String originalUrl, String shortCode) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}