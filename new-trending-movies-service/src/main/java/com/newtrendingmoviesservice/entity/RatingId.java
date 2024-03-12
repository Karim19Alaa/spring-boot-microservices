package com.newtrendingmoviesservice.entity;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RatingId implements Serializable {

    private String userId;

    public RatingId() {
    }
    public RatingId(String userId, String movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    private String movieId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}