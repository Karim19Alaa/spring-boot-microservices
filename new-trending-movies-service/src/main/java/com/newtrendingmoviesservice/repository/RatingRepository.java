package com.newtrendingmoviesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newtrendingmoviesservice.entity.RatingEntity;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {

    @Query(value = "SELECT r.movie_id FROM ratings r GROUP BY r.movie_id ORDER BY AVG(r.rating) DESC LIMIT :limit", nativeQuery = true)
    List<String> findTopRatedMovies(@Param("limit") Integer limit);

}
