package com.newtrendingmoviesservice.protobuf;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import com.newtrendingmoviesservice.models.Movie;
import com.newtrendingmoviesservice.repository.RatingRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;


@Service
public class TrendingMoviesServiceImpl extends TrendingMoviesServiceGrpc.TrendingMoviesServiceImplBase {

    RatingRepository ratingsRepo;
    public TrendingMoviesServiceImpl(RatingRepository ratingsRepo){
        this.ratingsRepo=ratingsRepo;
    }

    @Override
    public void getTopMoviesByRating(TrendingProto.TopMoviesRequest request, StreamObserver<TrendingProto.TopMoviesResponse> responseObserver) {
        List<Object[]> result = ratingsRepo.findTopRatedMovies(request.getLimit());
        List<TrendingProto.Movie> movies = new ArrayList<>();

        for (Object[] row : result) {
            String movieId = (String) row[0];
            String description = (String) row[1];
            String name = (String) row[2];
            double rating = ((BigDecimal) row[3]).doubleValue();

            movies.add(TrendingProto.Movie.newBuilder()
                    .setMovieId(movieId)
                    .setDescription(description)
                    .setName(name)
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
