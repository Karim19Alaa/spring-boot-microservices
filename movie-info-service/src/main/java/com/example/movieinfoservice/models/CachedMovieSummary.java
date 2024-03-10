package com.example.movieinfoservice.models;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("MovieSummaryCache")
public class CachedMovieSummary {
    
    @Id
    private String id;

    private String title;
    private String overview;

    private Date expiryDate;

    public CachedMovieSummary(MovieSummary movieSummary, long TTL){
        this.id = movieSummary.getId();
        this.expiryDate = Date.from(Instant.now().plusSeconds(TTL));
        this.title = movieSummary.getTitle();
        this.overview = movieSummary.getOverview();
    }

    public CachedMovieSummary(){};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public static CachedMovieSummary fromMovieSummary(MovieSummary movieSummary, long TTL) {
        return new CachedMovieSummary(movieSummary, TTL);
    }

    

}