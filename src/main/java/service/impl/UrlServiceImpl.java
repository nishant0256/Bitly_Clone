package service.impl;

import dto.*;
import entity.UrlMapping;
import repository.UrlRepository;
import service.UrlService;
import util.Base62Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private static final String BASE_URL = "http://localhost:8080/";

    // 🔹 1. Shorten URL
    @Override
    public UrlResponseDto shortenUrl(UrlRequestDto request) {

        UrlMapping entity = new UrlMapping();
        entity.setOriginalUrl(request.getUrl());

        // Step 1: Save first to get ID (Oracle sequence)
        urlRepository.save(entity);

        // Step 2: Generate short code using Base62
        String shortCode = Base62Encoder.encode(entity.getId());

        // Optional: custom alias
        if (request.getCustomAlias() != null && !request.getCustomAlias().isEmpty()) {
            shortCode = request.getCustomAlias();
        }

        entity.setShortCode(shortCode);

        // Optional: expiry
        if (request.getExpiryDays() != null) {
            entity.setExpiryDate(LocalDateTime.now().plusDays(request.getExpiryDays()));
        }

        urlRepository.save(entity);

        return new UrlResponseDto(
                entity.getOriginalUrl(),
                BASE_URL + shortCode,
                shortCode,
                entity.getClickCount()
        );
    }

    // 🔹 2. Redirect Logic
    @Override
    public String getOriginalUrl(String shortCode) {

        UrlMapping entity = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        // Check expiry
        if (entity.getExpiryDate() != null &&
                entity.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("URL expired");
        }

        // Increment click count
        entity.setClickCount(entity.getClickCount() + 1);
        urlRepository.save(entity);

        return entity.getOriginalUrl();
    }

    // 🔹 3. Stats API
    @Override
    public StatsResponseDto getStats(String shortCode) {

        UrlMapping entity = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        return new StatsResponseDto(
                entity.getShortCode(),
                entity.getOriginalUrl(),
                entity.getClickCount(),
                entity.getCreatedAt()
        );
    }
}