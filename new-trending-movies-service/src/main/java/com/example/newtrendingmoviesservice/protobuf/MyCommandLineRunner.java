package com.example.newtrendingmoviesservice.protobuf;

import com.example.newtrendingmoviesservice.repository.MovieRepository;
import com.example.newtrendingmoviesservice.repository.RatingRepository;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
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
        Server server = ServerBuilder.forPort(8086)
                .addService(new TrendingMoviesServiceImpl(ratingRepo, movieRepo)).build();
        server.start();
        server.awaitTermination();

    }
}
