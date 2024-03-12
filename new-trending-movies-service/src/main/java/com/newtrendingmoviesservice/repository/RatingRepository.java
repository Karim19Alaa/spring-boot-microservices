package com.newtrendingmoviesservice.repository;

import com.newtrendingmoviesservice.entity.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newtrendingmoviesservice.entity.RatingEntity;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, RatingId> {
    @Query(value = "SELECT movie_id, AVG(rating) as avg_rating " +
            "FROM ratings " +
            "GROUP BY movie_id " +
            "ORDER BY avg_rating DESC " +
            "LIMIT :limit", nativeQuery = true)
    List<Object[]> findTopRatedMovies(@Param("limit") Integer limit);
}
