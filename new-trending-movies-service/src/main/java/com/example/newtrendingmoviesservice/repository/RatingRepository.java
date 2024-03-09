package com.example.newtrendingmoviesservice.repository;

import com.example.ratingsservice.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
    List<RatingEntity> findByUserId(String userId);
}
