package com.challenge.backend.urlshortener.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "urls")
public class UrlEntity {
    @Id
    private String id;
    private String shortUrl;
    private String fullUrl;
    private int  accessCount;
    public UrlEntity(String id, String fullUrl, String shortUrl) {
        this.id = id;
        this.fullUrl=fullUrl;
        this.shortUrl= shortUrl;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getShortUrl() {
        return shortUrl;
    }
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    public String getFullUrl() {
        return fullUrl;
    }
    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }
    public int getAccessCount() {
        return accessCount;
    }
    public void setAccessCount(int totalAccesses) {
        this.accessCount= totalAccesses;
    }
}
