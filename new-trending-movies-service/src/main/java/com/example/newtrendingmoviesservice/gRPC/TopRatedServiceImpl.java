package com.example.newtrendingmoviesservice.gRPC;

import com.example.newtrendingmoviesservice.models.Movie;
import com.example.newtrendingmoviesservice.repository.RatingRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopRatedServiceImpl extends TopRatedServiceGrpc.TopRatedServiceImplBase {
    RatingRepository ratingsRepo;
    public TopRatedServiceImpl(RatingRepository ratingsRepo){
        this.ratingsRepo=ratingsRepo;
    }

    @Override
    public void getTopRatedMovies(GRPC.TopRatedRequest request, StreamObserver<GRPC.TopRatedResponse> responseObserver) {
        List<Movie> dbMovies = ratingsRepo.getTopRatedMovies();
        List<GRPC.Movie> movies = new ArrayList<>();
        for(Movie movie:dbMovies){
            movies.add(GRPC.Movie.newBuilder()
                    .setMovieId(movie.getMovieId())
                    .setDescription(movie.getDescription())
                    .setName(movie.getName())
                    .build());
        }

        // Create a response message with the list of movies
        GRPC.TopRatedResponse response = GRPC.TopRatedResponse.newBuilder()
                .addAllMovie(movies)
                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
