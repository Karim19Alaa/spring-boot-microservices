package com.trendingmoviesservice.protobuf;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trendingmoviesservice.repository.RatingRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Value("${server.grpc.port}")
    private int port;

    RatingRepository ratingRepo;

    public MyCommandLineRunner(RatingRepository ratingsRepo){
        ratingRepo =ratingsRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // your code to run on startup goes here
        System.out.println("My command line runner executed");
            Server server = ServerBuilder.forPort(port)
                    .addService(new TrendingMoviesServiceImpl(ratingRepo)).build();
            server.start();
            server.awaitTermination();

    }
}
