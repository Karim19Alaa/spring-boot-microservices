package com.example.newtrendingmoviesservice.repository;

import com.example.newtrendingmoviesservice.dto.MovieRatingDto;
import com.example.newtrendingmoviesservice.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {

    @Query(value = "SELECT r.movie_id as movieId, AVG(r.rating) as avgRating FROM RatingEntity r GROUP BY r.movie_id ORDER BY avgRating DESC LIMIT :limit", nativeQuery = true)
    List<MovieRatingDto> findTopRatedMovies(@Param("limit") Integer limit);

}
