package com.example.movieinfoservice.repository;

import com.example.movieinfoservice.models.CachedMovieSummary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CachedMovieSummaryRepository extends MongoRepository<CachedMovieSummary, String>{
}
