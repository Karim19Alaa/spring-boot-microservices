package com.moviecatalogservice.resources;

import com.moviecatalogservice.models.CatalogItem;
import com.moviecatalogservice.models.Rating;
import com.moviecatalogservice.services.MovieInfoService;
import com.moviecatalogservice.services.UserRatingService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {


    private final MovieInfoService movieInfoService;

    private final UserRatingService userRatingService;

    private final TrendingServiceClient trendingServiceClient;

    public MovieCatalogResource(MovieInfoService movieInfoService,
                                UserRatingService userRatingService,
                                TrendingServiceClient trendingServiceClient) {

        this.movieInfoService = movieInfoService;
        this.userRatingService = userRatingService;
        this.trendingServiceClient = trendingServiceClient;
    }

    /**
     * Makes a call to MovieInfoService to get movieId, name and description,
     * Makes a call to RatingsService to get ratings
     * Accumulates both data to create a MovieCatalog
     * @param userId
     * @return CatalogItem that contains name, description and rating
     */
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        List<Rating> ratings = userRatingService.getUserRating(userId).getRatings();
        return ratings.stream().map(movieInfoService::getCatalogItem).collect(Collectors.toList());
    }
    
    @GetMapping("/trending")
    public ResponseEntity<List<CatalogItem>> getTrendingMovies(@RequestParam int limit) {
        if(limit < 0)   return ResponseEntity.badRequest().build();
        
        List<Rating> ratings = this.trendingServiceClient.getTrendingMovies(limit);
        List<CatalogItem> trendingMovies = ratings.stream().map(movieInfoService::getCatalogItem).collect(Collectors.toList());

        return ResponseEntity.ok(trendingMovies);
    }
    
}
