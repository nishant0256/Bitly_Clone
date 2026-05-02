package service;

import dto.StatsResponseDto;
import dto.UrlRequestDto;
import dto.UrlResponseDto;

public interface UrlService {

	 UrlResponseDto shortenUrl(UrlRequestDto request);

	    String getOriginalUrl(String shortCode);

	    StatsResponseDto getStats(String shortCode);
}
