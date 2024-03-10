package com.example.movieinfoservice.services;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.example.movieinfoservice.models.MovieSummary;
import com.example.movieinfoservice.models.CachedMovieSummary;

@Service
@Primary
public class MovieInfoCacheServiceImpl implements MovieInfoService{

    Logger logger = LoggerFactory.getLogger(MovieInfoAPIServiceImpl.class);

    private final MovieInfoAPIServiceImpl movieInfoAPIService;
    private final MongoRepository<CachedMovieSummary, String> movieInfoRepository;

    @Value("${movie_info_cache.ttl}")
    private long TTL;

    public MovieInfoCacheServiceImpl(MovieInfoAPIServiceImpl movieInfoAPIService,
                                     MongoRepository<CachedMovieSummary, String> movieInfoRepository){
        this.movieInfoAPIService = movieInfoAPIService;
        this.movieInfoRepository = movieInfoRepository;
    }

    @Override
    public MovieSummary getMovieInfo(String movieID) {
        Optional<CachedMovieSummary> optionalMovieSummary = this.movieInfoRepository.findById(movieID);

        if(!optionalMovieSummary.isPresent()
            || optionalMovieSummary.get().getExpiryDate().before(Date.from(Instant.now()))){

            logger.info("Movie with ID: " + movieID + " missed the cache");

            MovieSummary movieSummary = this.movieInfoAPIService.getMovieInfo(movieID);
            this.movieInfoRepository.save(CachedMovieSummary.fromMovieSummary(movieSummary, TTL));
            return movieSummary;
        }

        logger.info("Movie with ID: " + movieID + " hit the cache");
        return MovieSummary.fromCachedMovieSummary(optionalMovieSummary.get());
    }
    
}
