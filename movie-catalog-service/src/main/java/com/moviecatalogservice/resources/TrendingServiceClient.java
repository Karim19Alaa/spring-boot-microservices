package com.moviecatalogservice.resources;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.moviecatalogservice.models.Rating;
import com.trendingmoviesservice.protobuf.TrendingMoviesServiceGrpc;
import com.trendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest;
import com.trendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse;



@Service
public class TrendingServiceClient {

    @Value("${grpc.server.trending_service.address}")
    String serverAddress;

    TrendingMoviesServiceGrpc.TrendingMoviesServiceBlockingStub trendingMoviesServiceBlockingStub;

    @PostConstruct
    public void init(){
        ManagedChannel channel = ManagedChannelBuilder.forTarget(serverAddress).usePlaintext().build();
        this.trendingMoviesServiceBlockingStub = TrendingMoviesServiceGrpc.newBlockingStub(channel);
    }

    public List<Rating> getTrendingMovies(int limit) {


    TopMoviesRequest request = TopMoviesRequest.newBuilder()
                                                .setLimit(limit)
                                                .build();

    TopMoviesResponse reply = trendingMoviesServiceBlockingStub.getTopMoviesByRating(request);


    return reply.getTopMoviesList()
                .stream()
                .map(movie -> new Rating(movie.getMovieId(), movie.getRating()))
                .collect(Collectors.toList());

    }

}