package com.example.movieinfoservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.movieinfoservice.models.MovieSummary;

@Service
public class MovieInfoAPIServiceImpl implements MovieInfoService{

    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    public MovieInfoAPIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public MovieSummary getMovieInfo(String movieID) {
        final String url = "https://api.themoviedb.org/3/movie/" + movieID + "?api_key=" + apiKey;
        System.out.println("================================================================");
        System.out.println(url);
        System.out.println("================================================================");

        return restTemplate.getForObject(url, MovieSummary.class);
    }
    
}
