package com.moviecatalogservice.models;

public class Movie {

    private String movieId;
    private String name;
    private String description;

    public Movie() {
    }

    public Movie(String movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }
    public Movie(com.newtrendingmoviesservice.protobuf.TrendingProto.Movie movie) {
        this.movieId = movie.getMovieId();
        this.name = movie.getName();
        this.description = movie.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
