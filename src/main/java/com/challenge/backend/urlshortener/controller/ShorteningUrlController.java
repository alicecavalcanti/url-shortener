package com.challenge.backend.urlshortener.controller;
import com.challenge.backend.urlshortener.dto.ShortenUrlRequest;
import com.challenge.backend.urlshortener.dto.ShortenUrlResponse;
import com.challenge.backend.urlshortener.services.ShorteningUrlService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShorteningUrlController{

    private final ShorteningUrlService urlService;

    public ShorteningUrlController(ShorteningUrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest request, HttpServletRequest servletRequest) {
        ShortenUrlResponse response = urlService.shortenUrl(request, servletRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") String id) {
        ResponseEntity<Void> response = urlService.handleRedirect(id);
        return response;
    }
}
