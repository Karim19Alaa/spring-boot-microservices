package com.example.ratingsservice.entity;

import com.example.ratingsservice.models.Rating;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "ratings")
@Table(name = "ratings")
public class RatingEntity {

    @EmbeddedId
    private RatingId id;
    private int rating;

    public RatingEntity(RatingId id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public RatingEntity() {
    }
    public Rating toRating() {
        return new Rating(id.getMovieId(), this.rating);
    }

    public RatingId getId() {
        return id;
    }

    public void setId(RatingId id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
