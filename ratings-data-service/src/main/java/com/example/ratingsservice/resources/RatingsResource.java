package com.example.ratingsservice.resources;

import com.example.ratingsservice.entity.RatingEntity;
import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.UserRating;
import com.example.ratingsservice.repository.RatingRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    private final RatingRepository ratingRepository;

    public RatingsResource(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }


    @RequestMapping("/{userId}")
    public UserRating getRatingsOfUser(@PathVariable String userId) {
        List<RatingEntity> ratingEntities = ratingRepository.findByUserId(userId);
        List<Rating> ratings = ratingEntities.stream()
                .map(RatingEntity::toRating)
                .collect(Collectors.toList());

        return new UserRating(ratings);
    }
}
