package com.example.ratingsservice.repository;

import com.example.ratingsservice.entity.RatingEntity;
import com.example.ratingsservice.entity.RatingId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, RatingId> {
    List<RatingEntity> findByUserId(String userId);
}
