package com.challenge.backend.urlshortener.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Document(collection = "urls")
public class UrlEntity {
    @Id
    private String id;
    private String shortUrl;
    private String fullUrl;
    private int  accessCount;
    private double  accessMediumDay;
    private Map<LocalDate, Integer> dailyAccesses;

    public UrlEntity(){}

    public UrlEntity(String id, String fullUrl, String shortUrl) {
        this.id = id;
        this.fullUrl=fullUrl;
        this.shortUrl= shortUrl;
        this.dailyAccesses = new HashMap<>();
    }
    
    // Método para incrementar o contador de acessos e atualizar a data atual no mapa
    public void incrementAccessCount() {
        accessCount++;
        LocalDate today = LocalDate.now();
        this.dailyAccesses.put(today, this.dailyAccesses.getOrDefault(today, 0) + 1);
    }

    // Método para calcular a média de acessos por dia
    public double calculateAverageAccessesPerDay(){
        int totalAccesses = accessCount;
        int totalDays = dailyAccesses.size();

        if (totalDays == 0) {
            return 0; // Evita divisão por zero
        }
        return Math.round((double) totalAccesses / totalDays);
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

    public double getAccessMediumDay() {
        return accessMediumDay;
    }
    public void setAccessMediumDay(double mediumAccessDay) {
        this.accessMediumDay = mediumAccessDay;
    }

    public Map<LocalDate, Integer> getDailyAccesses() {
        return dailyAccesses;
    }
    public void setDailyAccesses(Map<LocalDate, Integer> dailyAccesses) {
        this.dailyAccesses = dailyAccesses;
    }


}