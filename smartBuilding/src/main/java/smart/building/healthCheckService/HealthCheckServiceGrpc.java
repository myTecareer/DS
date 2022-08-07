package smart.building.healthCheckService;

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
    comments = "Source: healthCheckService.proto")
public final class HealthCheckServiceGrpc {

  private HealthCheckServiceGrpc() {}

  public static final String SERVICE_NAME = "smart.HealthCheckService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smart.building.healthCheckService.BuildingAirRequest,
      smart.building.healthCheckService.BuildingAirReply> getBuildingAirConditionCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "buildingAirConditionCheck",
      requestType = smart.building.healthCheckService.BuildingAirRequest.class,
      responseType = smart.building.healthCheckService.BuildingAirReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<smart.building.healthCheckService.BuildingAirRequest,
      smart.building.healthCheckService.BuildingAirReply> getBuildingAirConditionCheckMethod() {
    io.grpc.MethodDescriptor<smart.building.healthCheckService.BuildingAirRequest, smart.building.healthCheckService.BuildingAirReply> getBuildingAirConditionCheckMethod;
    if ((getBuildingAirConditionCheckMethod = HealthCheckServiceGrpc.getBuildingAirConditionCheckMethod) == null) {
      synchronized (HealthCheckServiceGrpc.class) {
        if ((getBuildingAirConditionCheckMethod = HealthCheckServiceGrpc.getBuildingAirConditionCheckMethod) == null) {
          HealthCheckServiceGrpc.getBuildingAirConditionCheckMethod = getBuildingAirConditionCheckMethod = 
              io.grpc.MethodDescriptor.<smart.building.healthCheckService.BuildingAirRequest, smart.building.healthCheckService.BuildingAirReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smart.HealthCheckService", "buildingAirConditionCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.healthCheckService.BuildingAirRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.healthCheckService.BuildingAirReply.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthCheckServiceMethodDescriptorSupplier("buildingAirConditionCheck"))
                  .build();
          }
        }
     }
     return getBuildingAirConditionCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<smart.building.healthCheckService.AirAlarmRequest,
      smart.building.healthCheckService.AirAlarmReply> getHarmfulAirAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "harmfulAirAlarm",
      requestType = smart.building.healthCheckService.AirAlarmRequest.class,
      responseType = smart.building.healthCheckService.AirAlarmReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<smart.building.healthCheckService.AirAlarmRequest,
      smart.building.healthCheckService.AirAlarmReply> getHarmfulAirAlarmMethod() {
    io.grpc.MethodDescriptor<smart.building.healthCheckService.AirAlarmRequest, smart.building.healthCheckService.AirAlarmReply> getHarmfulAirAlarmMethod;
    if ((getHarmfulAirAlarmMethod = HealthCheckServiceGrpc.getHarmfulAirAlarmMethod) == null) {
      synchronized (HealthCheckServiceGrpc.class) {
        if ((getHarmfulAirAlarmMethod = HealthCheckServiceGrpc.getHarmfulAirAlarmMethod) == null) {
          HealthCheckServiceGrpc.getHarmfulAirAlarmMethod = getHarmfulAirAlarmMethod = 
              io.grpc.MethodDescriptor.<smart.building.healthCheckService.AirAlarmRequest, smart.building.healthCheckService.AirAlarmReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smart.HealthCheckService", "harmfulAirAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.healthCheckService.AirAlarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.healthCheckService.AirAlarmReply.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthCheckServiceMethodDescriptorSupplier("harmfulAirAlarm"))
                  .build();
          }
        }
     }
     return getHarmfulAirAlarmMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HealthCheckServiceStub newStub(io.grpc.Channel channel) {
    return new HealthCheckServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthCheckServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HealthCheckServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HealthCheckServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HealthCheckServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HealthCheckServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void buildingAirConditionCheck(smart.building.healthCheckService.BuildingAirRequest request,
        io.grpc.stub.StreamObserver<smart.building.healthCheckService.BuildingAirReply> responseObserver) {
      asyncUnimplementedUnaryCall(getBuildingAirConditionCheckMethod(), responseObserver);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void harmfulAirAlarm(smart.building.healthCheckService.AirAlarmRequest request,
        io.grpc.stub.StreamObserver<smart.building.healthCheckService.AirAlarmReply> responseObserver) {
      asyncUnimplementedUnaryCall(getHarmfulAirAlarmMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBuildingAirConditionCheckMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                smart.building.healthCheckService.BuildingAirRequest,
                smart.building.healthCheckService.BuildingAirReply>(
                  this, METHODID_BUILDING_AIR_CONDITION_CHECK)))
          .addMethod(
            getHarmfulAirAlarmMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                smart.building.healthCheckService.AirAlarmRequest,
                smart.building.healthCheckService.AirAlarmReply>(
                  this, METHODID_HARMFUL_AIR_ALARM)))
          .build();
    }
  }

  /**
   */
  public static final class HealthCheckServiceStub extends io.grpc.stub.AbstractStub<HealthCheckServiceStub> {
    private HealthCheckServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthCheckServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthCheckServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthCheckServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void buildingAirConditionCheck(smart.building.healthCheckService.BuildingAirRequest request,
        io.grpc.stub.StreamObserver<smart.building.healthCheckService.BuildingAirReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getBuildingAirConditionCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void harmfulAirAlarm(smart.building.healthCheckService.AirAlarmRequest request,
        io.grpc.stub.StreamObserver<smart.building.healthCheckService.AirAlarmReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getHarmfulAirAlarmMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HealthCheckServiceBlockingStub extends io.grpc.stub.AbstractStub<HealthCheckServiceBlockingStub> {
    private HealthCheckServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthCheckServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthCheckServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthCheckServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public java.util.Iterator<smart.building.healthCheckService.BuildingAirReply> buildingAirConditionCheck(
        smart.building.healthCheckService.BuildingAirRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getBuildingAirConditionCheckMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public java.util.Iterator<smart.building.healthCheckService.AirAlarmReply> harmfulAirAlarm(
        smart.building.healthCheckService.AirAlarmRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getHarmfulAirAlarmMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HealthCheckServiceFutureStub extends io.grpc.stub.AbstractStub<HealthCheckServiceFutureStub> {
    private HealthCheckServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthCheckServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthCheckServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthCheckServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_BUILDING_AIR_CONDITION_CHECK = 0;
  private static final int METHODID_HARMFUL_AIR_ALARM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HealthCheckServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HealthCheckServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BUILDING_AIR_CONDITION_CHECK:
          serviceImpl.buildingAirConditionCheck((smart.building.healthCheckService.BuildingAirRequest) request,
              (io.grpc.stub.StreamObserver<smart.building.healthCheckService.BuildingAirReply>) responseObserver);
          break;
        case METHODID_HARMFUL_AIR_ALARM:
          serviceImpl.harmfulAirAlarm((smart.building.healthCheckService.AirAlarmRequest) request,
              (io.grpc.stub.StreamObserver<smart.building.healthCheckService.AirAlarmReply>) responseObserver);
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

  private static abstract class HealthCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthCheckServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smart.building.healthCheckService.HealthCheckServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthCheckService");
    }
  }

  private static final class HealthCheckServiceFileDescriptorSupplier
      extends HealthCheckServiceBaseDescriptorSupplier {
    HealthCheckServiceFileDescriptorSupplier() {}
  }

  private static final class HealthCheckServiceMethodDescriptorSupplier
      extends HealthCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HealthCheckServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HealthCheckServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HealthCheckServiceFileDescriptorSupplier())
              .addMethod(getBuildingAirConditionCheckMethod())
              .addMethod(getHarmfulAirAlarmMethod())
              .build();
        }
      }
    }
    return result;
  }
}
