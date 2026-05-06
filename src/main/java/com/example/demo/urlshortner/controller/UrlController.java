package com.example.demo.urlshortner.controller;

import com.example.demo.urlshortner.dto.UrlRequestDto;
import com.example.demo.urlshortner.dto.UrlResponseDto;
import com.example.demo.urlshortner.dto.StatsResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import com.example.demo.urlshortner.service.UrlService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*") // allow React frontend
public class UrlController {

    @Autowired
    private UrlService urlService;

    // 🔹 1. Create Short URL
    @Operation(summary = "Create a short URL")
    @PostMapping("/api/shorten")
    public ResponseEntity<UrlResponseDto> shortenUrl(@Valid @RequestBody UrlRequestDto request) {

        UrlResponseDto response = urlService.shortenUrl(request);
        return ResponseEntity.ok(response);
    }

    // 🔹 2. Redirect to Original URL
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }

    // 🔹 3. Get URL Stats
    @GetMapping("/api/stats/{shortCode}")
    public ResponseEntity<StatsResponseDto> getStats(@PathVariable String shortCode) {

        StatsResponseDto stats = urlService.getStats(shortCode);
        return ResponseEntity.ok(stats);
    }
}