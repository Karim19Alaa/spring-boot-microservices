package com.newtrendingmoviesservice.protobuf;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.newtrendingmoviesservice.repository.MovieRepository;
import com.newtrendingmoviesservice.repository.RatingRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Value("${server.grpc.port}")
    private int port;

    RatingRepository ratingRepo;
    MovieRepository movieRepo;

    public MyCommandLineRunner(RatingRepository ratingsRepo, MovieRepository movieRepo){
        ratingRepo =ratingsRepo;
        this.movieRepo=movieRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // your code to run on startup goes here
        System.out.println("My command line runner executed");
            Server server = ServerBuilder.forPort(port)
                    .addService(new TrendingMoviesServiceImpl(ratingRepo, movieRepo)).build();
            server.start();
            server.awaitTermination();

    }
}
