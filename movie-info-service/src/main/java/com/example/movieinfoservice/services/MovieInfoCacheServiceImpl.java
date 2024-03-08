package com.example.movieinfoservice.services;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.example.movieinfoservice.models.MovieSummary;

@Service
@Primary
public class MovieInfoCacheServiceImpl implements MovieInfoService{

    private final MovieInfoAPIServiceImpl movieInfoAPIService;
    private final MongoRepository<MovieSummary, String> movieInfoRepository;

    public MovieInfoCacheServiceImpl(MovieInfoAPIServiceImpl movieInfoAPIService,
                                     MongoRepository<MovieSummary, String> movieInfoRepository){
        this.movieInfoAPIService = movieInfoAPIService;
        this.movieInfoRepository = movieInfoRepository;
    }

    @Override
    public MovieSummary getMovieInfo(String movieID) {
        Optional<MovieSummary> optionalMovieSummary =  this.movieInfoRepository.findById(movieID.split("-")[0]);

        if(!optionalMovieSummary.isPresent()){
            MovieSummary movieSummary = this.movieInfoAPIService.getMovieInfo(movieID);
            this.movieInfoRepository.insert(movieSummary);
            return movieSummary;
        }
        return optionalMovieSummary.get();
    }
    
}
