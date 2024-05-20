package com.challenge.backend.urlshortener.controller;

import com.challenge.backend.urlshortener.dto.ShortenUrlRequest;
import com.challenge.backend.urlshortener.dto.ShortenUrlResponse;
import com.challenge.backend.urlshortener.entities.UrlEntity;
import com.challenge.backend.urlshortener.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlController {
    private final UrlRepository urlRepository;

    public UrlController(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }
    @PostMapping(value = "/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest request, HttpServletRequest servletRequest){
        String id;
        do{
            id = RandomStringUtils.randomAlphanumeric(5, 10);

        }while (urlRepository.existsById(id));

        var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);

        urlRepository.save(new UrlEntity(id, request.url(), redirectUrl));

        return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
    }
    @GetMapping("{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") String id){
        var url = urlRepository.findById(id);

        if(url.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        UrlEntity urlID = url.get();

        // Incrementa o contador de acesso
        urlID.setAccessCount(urlID.getAccessCount() + 1);

        // Salva a entidade atualizada no banco de dados
        urlRepository.save(urlID);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.get().getFullUrl()));

        return ResponseEntity.status(HttpStatus.FOUND).headers((headers)).build();
    }




}
