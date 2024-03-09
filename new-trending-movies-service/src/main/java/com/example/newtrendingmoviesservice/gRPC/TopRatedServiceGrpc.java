package com.example.newtrendingmoviesservice.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: gRPC.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TopRatedServiceGrpc {

  private TopRatedServiceGrpc() {}

  public static final String SERVICE_NAME = "TopRatedService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GRPC.TopRatedRequest,
      GRPC.TopRatedResponse> getGetTopRatedMoviesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTopRatedMovies",
      requestType = GRPC.TopRatedRequest.class,
      responseType = GRPC.TopRatedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPC.TopRatedRequest,
      GRPC.TopRatedResponse> getGetTopRatedMoviesMethod() {
    io.grpc.MethodDescriptor<GRPC.TopRatedRequest, GRPC.TopRatedResponse> getGetTopRatedMoviesMethod;
    if ((getGetTopRatedMoviesMethod = TopRatedServiceGrpc.getGetTopRatedMoviesMethod) == null) {
      synchronized (TopRatedServiceGrpc.class) {
        if ((getGetTopRatedMoviesMethod = TopRatedServiceGrpc.getGetTopRatedMoviesMethod) == null) {
          TopRatedServiceGrpc.getGetTopRatedMoviesMethod = getGetTopRatedMoviesMethod =
              io.grpc.MethodDescriptor.<GRPC.TopRatedRequest, GRPC.TopRatedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTopRatedMovies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPC.TopRatedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPC.TopRatedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TopRatedServiceMethodDescriptorSupplier("GetTopRatedMovies"))
              .build();
        }
      }
    }
    return getGetTopRatedMoviesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TopRatedServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TopRatedServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TopRatedServiceStub>() {
        @Override
        public TopRatedServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TopRatedServiceStub(channel, callOptions);
        }
      };
    return TopRatedServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TopRatedServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TopRatedServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TopRatedServiceBlockingStub>() {
        @Override
        public TopRatedServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TopRatedServiceBlockingStub(channel, callOptions);
        }
      };
    return TopRatedServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TopRatedServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TopRatedServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TopRatedServiceFutureStub>() {
        @Override
        public TopRatedServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TopRatedServiceFutureStub(channel, callOptions);
        }
      };
    return TopRatedServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TopRatedServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTopRatedMovies(GRPC.TopRatedRequest request,
                                  io.grpc.stub.StreamObserver<GRPC.TopRatedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTopRatedMoviesMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTopRatedMoviesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GRPC.TopRatedRequest,
                GRPC.TopRatedResponse>(
                  this, METHODID_GET_TOP_RATED_MOVIES)))
          .build();
    }
  }

  /**
   */
  public static final class TopRatedServiceStub extends io.grpc.stub.AbstractAsyncStub<TopRatedServiceStub> {
    private TopRatedServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TopRatedServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TopRatedServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTopRatedMovies(GRPC.TopRatedRequest request,
                                  io.grpc.stub.StreamObserver<GRPC.TopRatedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTopRatedMoviesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TopRatedServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TopRatedServiceBlockingStub> {
    private TopRatedServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TopRatedServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TopRatedServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPC.TopRatedResponse getTopRatedMovies(GRPC.TopRatedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTopRatedMoviesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TopRatedServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TopRatedServiceFutureStub> {
    private TopRatedServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TopRatedServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TopRatedServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.TopRatedResponse> getTopRatedMovies(
        GRPC.TopRatedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTopRatedMoviesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TOP_RATED_MOVIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TopRatedServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TopRatedServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TOP_RATED_MOVIES:
          serviceImpl.getTopRatedMovies((GRPC.TopRatedRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.TopRatedResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TopRatedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TopRatedServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPC.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TopRatedService");
    }
  }

  private static final class TopRatedServiceFileDescriptorSupplier
      extends TopRatedServiceBaseDescriptorSupplier {
    TopRatedServiceFileDescriptorSupplier() {}
  }

  private static final class TopRatedServiceMethodDescriptorSupplier
      extends TopRatedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TopRatedServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TopRatedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TopRatedServiceFileDescriptorSupplier())
              .addMethod(getGetTopRatedMoviesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
