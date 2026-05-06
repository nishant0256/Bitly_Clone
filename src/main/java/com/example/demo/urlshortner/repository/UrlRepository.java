package com.example.demo.urlshortner.repository;

import com.example.demo.urlshortner.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlMapping, Long> {

    // Find by short code (used for redirect)
    Optional<UrlMapping> findByShortCode(String shortCode);

    // Check if short code already exists
    boolean existsByShortCode(String shortCode);
}