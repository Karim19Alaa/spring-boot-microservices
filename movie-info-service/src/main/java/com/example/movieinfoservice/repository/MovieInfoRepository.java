package com.example.movieinfoservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.movieinfoservice.models.MovieSummary;

public interface MovieInfoRepository extends MongoRepository<MovieSummary, String>{
    

}
