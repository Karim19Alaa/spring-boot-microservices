package com.example.movieinfoservice.services;

import com.example.movieinfoservice.models.MovieSummary;

public interface MovieInfoService {
    MovieSummary getMovieInfo(String movieID);
}
