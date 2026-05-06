package com.example.demo.urlshortner.service;

import com.example.demo.urlshortner.dto.StatsResponseDto;
import com.example.demo.urlshortner.dto.UrlRequestDto;
import com.example.demo.urlshortner.dto.UrlResponseDto;

public interface UrlService {

	 UrlResponseDto shortenUrl(UrlRequestDto request);

	    String getOriginalUrl(String shortCode);

	    StatsResponseDto getStats(String shortCode);
}
