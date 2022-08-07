package smart.building.airService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: airService.proto")
public final class AirServiceGrpc {

  private AirServiceGrpc() {}

  public static final String SERVICE_NAME = "smart.AirService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smart.building.airService.CurrentAirRequest,
      smart.building.airService.CurrentAirReply> getCurrAirQualityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "currAirQuality",
      requestType = smart.building.airService.CurrentAirRequest.class,
      responseType = smart.building.airService.CurrentAirReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<smart.building.airService.CurrentAirRequest,
      smart.building.airService.CurrentAirReply> getCurrAirQualityMethod() {
    io.grpc.MethodDescriptor<smart.building.airService.CurrentAirRequest, smart.building.airService.CurrentAirReply> getCurrAirQualityMethod;
    if ((getCurrAirQualityMethod = AirServiceGrpc.getCurrAirQualityMethod) == null) {
      synchronized (AirServiceGrpc.class) {
        if ((getCurrAirQualityMethod = AirServiceGrpc.getCurrAirQualityMethod) == null) {
          AirServiceGrpc.getCurrAirQualityMethod = getCurrAirQualityMethod = 
              io.grpc.MethodDescriptor.<smart.building.airService.CurrentAirRequest, smart.building.airService.CurrentAirReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smart.AirService", "currAirQuality"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.airService.CurrentAirRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.airService.CurrentAirReply.getDefaultInstance()))
                  .setSchemaDescriptor(new AirServiceMethodDescriptorSupplier("currAirQuality"))
                  .build();
          }
        }
     }
     return getCurrAirQualityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<smart.building.airService.AirPuriRequest,
      smart.building.airService.AirPuriReply> getOpenCloseAirPurifierMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "openCloseAirPurifier",
      requestType = smart.building.airService.AirPuriRequest.class,
      responseType = smart.building.airService.AirPuriReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<smart.building.airService.AirPuriRequest,
      smart.building.airService.AirPuriReply> getOpenCloseAirPurifierMethod() {
    io.grpc.MethodDescriptor<smart.building.airService.AirPuriRequest, smart.building.airService.AirPuriReply> getOpenCloseAirPurifierMethod;
    if ((getOpenCloseAirPurifierMethod = AirServiceGrpc.getOpenCloseAirPurifierMethod) == null) {
      synchronized (AirServiceGrpc.class) {
        if ((getOpenCloseAirPurifierMethod = AirServiceGrpc.getOpenCloseAirPurifierMethod) == null) {
          AirServiceGrpc.getOpenCloseAirPurifierMethod = getOpenCloseAirPurifierMethod = 
              io.grpc.MethodDescriptor.<smart.building.airService.AirPuriRequest, smart.building.airService.AirPuriReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smart.AirService", "openCloseAirPurifier"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.airService.AirPuriRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.airService.AirPuriReply.getDefaultInstance()))
                  .setSchemaDescriptor(new AirServiceMethodDescriptorSupplier("openCloseAirPurifier"))
                  .build();
          }
        }
     }
     return getOpenCloseAirPurifierMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AirServiceStub newStub(io.grpc.Channel channel) {
    return new AirServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AirServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AirServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AirServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AirServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AirServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<smart.building.airService.CurrentAirRequest> currAirQuality(
        io.grpc.stub.StreamObserver<smart.building.airService.CurrentAirReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getCurrAirQualityMethod(), responseObserver);
    }

    /**
     * <pre>
     *Bi-Directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<smart.building.airService.AirPuriRequest> openCloseAirPurifier(
        io.grpc.stub.StreamObserver<smart.building.airService.AirPuriReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getOpenCloseAirPurifierMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCurrAirQualityMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                smart.building.airService.CurrentAirRequest,
                smart.building.airService.CurrentAirReply>(
                  this, METHODID_CURR_AIR_QUALITY)))
          .addMethod(
            getOpenCloseAirPurifierMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                smart.building.airService.AirPuriRequest,
                smart.building.airService.AirPuriReply>(
                  this, METHODID_OPEN_CLOSE_AIR_PURIFIER)))
          .build();
    }
  }

  /**
   */
  public static final class AirServiceStub extends io.grpc.stub.AbstractStub<AirServiceStub> {
    private AirServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AirServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AirServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<smart.building.airService.CurrentAirRequest> currAirQuality(
        io.grpc.stub.StreamObserver<smart.building.airService.CurrentAirReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCurrAirQualityMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *Bi-Directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<smart.building.airService.AirPuriRequest> openCloseAirPurifier(
        io.grpc.stub.StreamObserver<smart.building.airService.AirPuriReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getOpenCloseAirPurifierMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AirServiceBlockingStub extends io.grpc.stub.AbstractStub<AirServiceBlockingStub> {
    private AirServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AirServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AirServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class AirServiceFutureStub extends io.grpc.stub.AbstractStub<AirServiceFutureStub> {
    private AirServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AirServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AirServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CURR_AIR_QUALITY = 0;
  private static final int METHODID_OPEN_CLOSE_AIR_PURIFIER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AirServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AirServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CURR_AIR_QUALITY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.currAirQuality(
              (io.grpc.stub.StreamObserver<smart.building.airService.CurrentAirReply>) responseObserver);
        case METHODID_OPEN_CLOSE_AIR_PURIFIER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.openCloseAirPurifier(
              (io.grpc.stub.StreamObserver<smart.building.airService.AirPuriReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AirServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AirServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smart.building.airService.AirControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AirService");
    }
  }

  private static final class AirServiceFileDescriptorSupplier
      extends AirServiceBaseDescriptorSupplier {
    AirServiceFileDescriptorSupplier() {}
  }

  private static final class AirServiceMethodDescriptorSupplier
      extends AirServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AirServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AirServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AirServiceFileDescriptorSupplier())
              .addMethod(getCurrAirQualityMethod())
              .addMethod(getOpenCloseAirPurifierMethod())
              .build();
        }
      }
    }
    return result;
  }
}
