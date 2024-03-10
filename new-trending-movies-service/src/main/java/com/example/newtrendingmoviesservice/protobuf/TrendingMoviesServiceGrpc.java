package com.example.newtrendingmoviesservice.protobuf;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 0.15.0)",
    comments = "Source: trending.proto")
public class TrendingMoviesServiceGrpc {

  private TrendingMoviesServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.newtrendingmoviesservice.protobuf.TrendingMoviesService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest,
      com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse> METHOD_GET_TOP_MOVIES_BY_RATING =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.example.newtrendingmoviesservice.protobuf.TrendingMoviesService", "GetTopMoviesByRating"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrendingMoviesServiceStub newStub(io.grpc.Channel channel) {
    return new TrendingMoviesServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrendingMoviesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrendingMoviesServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static TrendingMoviesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrendingMoviesServiceFutureStub(channel);
  }

  /**
   */
  @java.lang.Deprecated public static interface TrendingMoviesService {

    /**
     */
    public void getTopMoviesByRating(com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest request,
        io.grpc.stub.StreamObserver<com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse> responseObserver);
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1469")
  public static abstract class TrendingMoviesServiceImplBase implements TrendingMoviesService, io.grpc.BindableService {

    @java.lang.Override
    public void getTopMoviesByRating(com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest request,
        io.grpc.stub.StreamObserver<com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_TOP_MOVIES_BY_RATING, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return TrendingMoviesServiceGrpc.bindService(this);
    }
  }

  /**
   */
  @java.lang.Deprecated public static interface TrendingMoviesServiceBlockingClient {

    /**
     */
    public com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse getTopMoviesByRating(com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest request);
  }

  /**
   */
  @java.lang.Deprecated public static interface TrendingMoviesServiceFutureClient {

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse> getTopMoviesByRating(
        com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest request);
  }

  public static class TrendingMoviesServiceStub extends io.grpc.stub.AbstractStub<TrendingMoviesServiceStub>
      implements TrendingMoviesService {
    private TrendingMoviesServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrendingMoviesServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrendingMoviesServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrendingMoviesServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void getTopMoviesByRating(com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest request,
        io.grpc.stub.StreamObserver<com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TOP_MOVIES_BY_RATING, getCallOptions()), request, responseObserver);
    }
  }

  public static class TrendingMoviesServiceBlockingStub extends io.grpc.stub.AbstractStub<TrendingMoviesServiceBlockingStub>
      implements TrendingMoviesServiceBlockingClient {
    private TrendingMoviesServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrendingMoviesServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrendingMoviesServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrendingMoviesServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse getTopMoviesByRating(com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_TOP_MOVIES_BY_RATING, getCallOptions(), request);
    }
  }

  public static class TrendingMoviesServiceFutureStub extends io.grpc.stub.AbstractStub<TrendingMoviesServiceFutureStub>
      implements TrendingMoviesServiceFutureClient {
    private TrendingMoviesServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrendingMoviesServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrendingMoviesServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrendingMoviesServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse> getTopMoviesByRating(
        com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TOP_MOVIES_BY_RATING, getCallOptions()), request);
    }
  }

  @java.lang.Deprecated public static abstract class AbstractTrendingMoviesService extends TrendingMoviesServiceImplBase {}

  private static final int METHODID_GET_TOP_MOVIES_BY_RATING = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrendingMoviesService serviceImpl;
    private final int methodId;

    public MethodHandlers(TrendingMoviesService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TOP_MOVIES_BY_RATING:
          serviceImpl.getTopMoviesByRating((com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest) request,
              (io.grpc.stub.StreamObserver<com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_GET_TOP_MOVIES_BY_RATING);
  }

  @java.lang.Deprecated public static io.grpc.ServerServiceDefinition bindService(
      final TrendingMoviesService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          METHOD_GET_TOP_MOVIES_BY_RATING,
          asyncUnaryCall(
            new MethodHandlers<
              com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesRequest,
              com.example.newtrendingmoviesservice.protobuf.TrendingProto.TopMoviesResponse>(
                serviceImpl, METHODID_GET_TOP_MOVIES_BY_RATING)))
        .build();
  }
}
