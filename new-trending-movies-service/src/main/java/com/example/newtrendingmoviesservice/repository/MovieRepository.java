package com.example.newtrendingmoviesservice.repository;

import com.example.newtrendingmoviesservice.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, String> {
}


