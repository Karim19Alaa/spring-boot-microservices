package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import com.example.movieinfoservice.services.MovieInfoService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    private final MovieInfoService movieInfoService;

    public MovieResource(MovieInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @RequestMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieInfo(@PathVariable("movieId") String movieId) {
        try{
            MovieSummary movieSummary = this.movieInfoService.getMovieInfo(movieId);
            Movie movie = new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
            return ResponseEntity.ok(movie);
        }catch(RestClientException e){
            return ResponseEntity.notFound().build();
        }
    }

}
