package com.example.newtrendingmoviesservice.gRPC;

import com.example.newtrendingmoviesservice.repository.RatingRepository;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    RatingRepository repo ;
    public MyCommandLineRunner(RatingRepository ratingsRepo){
        repo=ratingsRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // your code to run on startup goes here
        System.out.println("My command line runner executed");
        Server server = ServerBuilder.forPort(8086)
                .addService(new TopRatedServiceImpl(repo)).build();
        server.start();
        server.awaitTermination();

    }
}
