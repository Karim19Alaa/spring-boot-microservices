package com.newtrendingmoviesservice.entity;

import javax.persistence.*;

import com.newtrendingmoviesservice.models.Rating;

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
