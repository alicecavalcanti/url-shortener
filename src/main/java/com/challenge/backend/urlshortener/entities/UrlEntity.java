package com.challenge.backend.urlshortener.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
public class UrlEntity {
    @Id
    private String id;
    private String fullUrl;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }


    public UrlEntity(){}
    public UrlEntity(String id, String fullUrl) {
        this.id = id;
        this.fullUrl=fullUrl;
    }

}
