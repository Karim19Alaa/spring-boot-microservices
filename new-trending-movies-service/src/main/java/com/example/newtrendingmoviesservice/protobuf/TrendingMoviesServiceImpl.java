package com.example.newtrendingmoviesservice.protobuf;

import com.example.newtrendingmoviesservice.models.Movie;
import com.example.newtrendingmoviesservice.repository.MovieRepository;
import com.example.newtrendingmoviesservice.repository.RatingRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;


@Service
public class TrendingMoviesServiceImpl extends TrendingMoviesServiceGrpc.TrendingMoviesServiceImplBase {

    RatingRepository ratingsRepo;
    MovieRepository movieRepo;
    public TrendingMoviesServiceImpl(RatingRepository ratingsRepo, MovieRepository movieRepo){
        this.ratingsRepo=ratingsRepo;
        this.movieRepo=movieRepo;
    }

    @Override
    public void getTopMoviesByRating(TrendingProto.TopMoviesRequest request, StreamObserver<TrendingProto.TopMoviesResponse> responseObserver) {
        System.out.println(request.getLimit());
        List<String> dbMovies = ratingsRepo.findTopRatedMovies(request.getLimit());
        List<TrendingProto.Movie> movies = new ArrayList<>();

        for(String movieID:dbMovies){
            Movie movie = movieRepo.findById(movieID).get().toMovie();
            movies.add(TrendingProto.Movie.newBuilder()
                    .setMovieId(movie.getMovieId())
                    .setDescription(movie.getDescription())
                    .setName(movie.getName())
                    .build());
        }

        TrendingProto.TopMoviesResponse response = TrendingProto.TopMoviesResponse.newBuilder()
                .addAllTopMovies(movies)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
