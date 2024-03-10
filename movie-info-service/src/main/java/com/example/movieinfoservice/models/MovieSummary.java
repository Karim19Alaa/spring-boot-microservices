package com.example.movieinfoservice.models;

public class MovieSummary {
    private String id;

    private String title;
    private String overview;

    public MovieSummary(String id, String title, String overview){
        super();
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public MovieSummary(CachedMovieSummary movieSummaryCache){
        super();
        this.id = movieSummaryCache.getId();
        this.title = movieSummaryCache.getTitle();
        this.overview = movieSummaryCache.getOverview();
    }

    public MovieSummary(){}
    
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

    public static MovieSummary fromCachedMovieSummary(CachedMovieSummary cachedMovieSummary) {
        return new MovieSummary(cachedMovieSummary);
    }
}
