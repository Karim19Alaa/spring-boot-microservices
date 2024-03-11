package com.newtrendingmoviesservice.protobuf;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import com.newtrendingmoviesservice.models.Movie;
import com.newtrendingmoviesservice.repository.MovieRepository;
import com.newtrendingmoviesservice.repository.RatingRepository;

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
            double rating = ratingsRepo.getAverageRatingByMovieId(movieID);

            movies.add(TrendingProto.Movie.newBuilder()
                    .setMovieId(movie.getMovieId())
                    .setDescription(movie.getDescription())
                    .setName(movie.getName())
                    .setRating(rating)
                    .build());
        }

        TrendingProto.TopMoviesResponse response = TrendingProto.TopMoviesResponse.newBuilder()
                .addAllTopMovies(movies)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
