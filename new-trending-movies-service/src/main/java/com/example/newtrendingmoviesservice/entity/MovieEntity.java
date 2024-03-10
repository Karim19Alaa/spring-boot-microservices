package com.example.newtrendingmoviesservice.entity;

import com.example.newtrendingmoviesservice.models.Movie;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name= "Movie")
public class MovieEntity {

    @Id
    private String movieId;
    private String name;
    private String description;

    public MovieEntity() {
    }

    public MovieEntity(String movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }

    public Movie toMovie(){
        return new Movie(movieId, name, description) ;
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
