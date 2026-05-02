package dto;

import jakarta.validation.constraints.NotBlank;

public class UrlRequestDto {

    @NotBlank(message = "URL cannot be empty")
    private String url;

    // Optional: custom alias
    private String customAlias;

    // Optional: expiry (in days)
    private Integer expiryDays;

    // Getters & Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCustomAlias() {
        return customAlias;
    }

    public void setCustomAlias(String customAlias) {
        this.customAlias = customAlias;
    }

    public Integer getExpiryDays() {
        return expiryDays;
    }

    public void setExpiryDays(Integer expiryDays) {
        this.expiryDays = expiryDays;
    }
}