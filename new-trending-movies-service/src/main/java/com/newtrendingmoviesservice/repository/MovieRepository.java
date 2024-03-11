package com.newtrendingmoviesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newtrendingmoviesservice.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, String> {
}


