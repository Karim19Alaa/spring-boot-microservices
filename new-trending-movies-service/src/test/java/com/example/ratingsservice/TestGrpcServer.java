package com.example.ratingsservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestGrpcServer {
    private static ManagedChannel channel;
    private static TrendingMoviesServiceGrpc.TrendingMoviesServiceBlockingStub blockingStub;

    @BeforeAll
    public static void setup() {
        // Set up the gRPC channel and stub
        channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        blockingStub = TrendingMoviesServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public static void tearDown() {
        // Shutdown the channel after all tests are executed
        channel.shutdown();
    }

    @Test
    public void testGetTopMoviesByRating() {
        // Create a sample request (modify as needed)
        TrendingProto.TopMoviesRequest request = TrendingProto.TopMoviesRequest.newBuilder().build();

        // Call the gRPC service method
        TrendingProto.TopMoviesResponse response = blockingStub.getTopMoviesByRating(request);

        // Assert that the response is not null
        assertNotNull(response);

        // Add additional assertions based on your service logic and expected responses
        // For example, check if the list of top movies is not empty
        assertFalse(response.getTopMoviesList().isEmpty());
        // print the response content
        System.out.println(response);

        // You can add more specific assertions based on your service logic and expected responses
    }
}
