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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RatingId other = (RatingId) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (movieId == null) {
            if (other.movieId != null)
                return false;
        } else if (!movieId.equals(other.movieId))
            return false;
        return true;
    }
    
}