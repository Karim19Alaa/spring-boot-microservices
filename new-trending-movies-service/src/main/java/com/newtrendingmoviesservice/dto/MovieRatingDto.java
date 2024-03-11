package com.newtrendingmoviesservice.dto;


public class MovieRatingDto {
    private String movieId;
    private Double avgRating;

    public MovieRatingDto(String movieId, Double avgRating) {
        this.movieId = movieId;
        this.avgRating = avgRating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }
}
