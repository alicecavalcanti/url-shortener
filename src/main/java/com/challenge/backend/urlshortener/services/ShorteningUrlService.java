package com.challenge.backend.urlshortener.services;
import com.challenge.backend.urlshortener.dto.ShortenUrlRequest;
import com.challenge.backend.urlshortener.dto.ShortenUrlResponse;
import com.challenge.backend.urlshortener.entities.UrlEntity;
import com.challenge.backend.urlshortener.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.net.URI;

@Service
public class ShorteningUrlService {

    private final UrlRepository urlRepository;

    UrlEntity urlEntity = new UrlEntity();

    public ShorteningUrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public ShortenUrlResponse shortenUrl(ShortenUrlRequest request, HttpServletRequest servletRequest) {
        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (urlRepository.existsById(id));

        var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);

        urlRepository.save(new UrlEntity(id, request.url(), redirectUrl));

        return new ShortenUrlResponse(redirectUrl);
    }

    public ResponseEntity<Void> handleRedirect(String id) {
        var url = urlRepository.findById(id);

        if (url.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UrlEntity urlID = url.get();

        // Incrementa o contador de acesso
        urlID.incrementAccessCount();
        urlID.calculateAverageAccessesPerDay();
        urlID.setAccessMediumDay(urlID.calculateAverageAccessesPerDay());

        // Salva a entidade atualizada no banco de dados
        urlRepository.save(urlID);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(urlID.getFullUrl()));

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

}
