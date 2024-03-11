package com.newtrendingmoviesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newtrendingmoviesservice.entity.RatingEntity;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
    @Query(value = "SELECT m.movie_id, m.description, m.name, AVG(r.rating) as avg_rating " +
            "FROM movie m " +
            "JOIN ratings r ON m.movie_id = r.movie_id " +
            "GROUP BY m.movie_id " +
            "ORDER BY avg_rating DESC " +
            "LIMIT :limit", nativeQuery = true)
    List<Object[]> findTopRatedMovies(@Param("limit") Integer limit);
}
