package com.example.newtrendingmoviesservice.protobuf;

import com.example.newtrendingmoviesservice.dto.MovieRatingDto;
import com.example.newtrendingmoviesservice.models.Movie;
import com.example.newtrendingmoviesservice.repository.MovieRepository;
import com.example.newtrendingmoviesservice.repository.RatingRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

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
        List<MovieRatingDto> dbMovies = ratingsRepo.findTopRatedMovies(10);
        List<TrendingProto.Movie> movies = new ArrayList<>();

        for(MovieRatingDto movieDTO:dbMovies){
            Movie movie = movieRepo.findById(movieDTO.getMovieId()).get().toMovie();
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
