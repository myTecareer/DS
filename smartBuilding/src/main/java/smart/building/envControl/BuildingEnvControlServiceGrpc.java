package smart.building.envControl;

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
    comments = "Source: envControl.proto")
public final class BuildingEnvControlServiceGrpc {

  private BuildingEnvControlServiceGrpc() {}

  public static final String SERVICE_NAME = "smart.BuildingEnvControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smart.building.envControl.ChangeRequest,
      smart.building.envControl.ChangeReply> getAirConditionerChangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "airConditionerChange",
      requestType = smart.building.envControl.ChangeRequest.class,
      responseType = smart.building.envControl.ChangeReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<smart.building.envControl.ChangeRequest,
      smart.building.envControl.ChangeReply> getAirConditionerChangeMethod() {
    io.grpc.MethodDescriptor<smart.building.envControl.ChangeRequest, smart.building.envControl.ChangeReply> getAirConditionerChangeMethod;
    if ((getAirConditionerChangeMethod = BuildingEnvControlServiceGrpc.getAirConditionerChangeMethod) == null) {
      synchronized (BuildingEnvControlServiceGrpc.class) {
        if ((getAirConditionerChangeMethod = BuildingEnvControlServiceGrpc.getAirConditionerChangeMethod) == null) {
          BuildingEnvControlServiceGrpc.getAirConditionerChangeMethod = getAirConditionerChangeMethod = 
              io.grpc.MethodDescriptor.<smart.building.envControl.ChangeRequest, smart.building.envControl.ChangeReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smart.BuildingEnvControlService", "airConditionerChange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.envControl.ChangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.envControl.ChangeReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BuildingEnvControlServiceMethodDescriptorSupplier("airConditionerChange"))
                  .build();
          }
        }
     }
     return getAirConditionerChangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<smart.building.envControl.HumidityRequest,
      smart.building.envControl.HumidityReply> getHumidityCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "humidityCheck",
      requestType = smart.building.envControl.HumidityRequest.class,
      responseType = smart.building.envControl.HumidityReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<smart.building.envControl.HumidityRequest,
      smart.building.envControl.HumidityReply> getHumidityCheckMethod() {
    io.grpc.MethodDescriptor<smart.building.envControl.HumidityRequest, smart.building.envControl.HumidityReply> getHumidityCheckMethod;
    if ((getHumidityCheckMethod = BuildingEnvControlServiceGrpc.getHumidityCheckMethod) == null) {
      synchronized (BuildingEnvControlServiceGrpc.class) {
        if ((getHumidityCheckMethod = BuildingEnvControlServiceGrpc.getHumidityCheckMethod) == null) {
          BuildingEnvControlServiceGrpc.getHumidityCheckMethod = getHumidityCheckMethod = 
              io.grpc.MethodDescriptor.<smart.building.envControl.HumidityRequest, smart.building.envControl.HumidityReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smart.BuildingEnvControlService", "humidityCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.envControl.HumidityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.building.envControl.HumidityReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BuildingEnvControlServiceMethodDescriptorSupplier("humidityCheck"))
                  .build();
          }
        }
     }
     return getHumidityCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BuildingEnvControlServiceStub newStub(io.grpc.Channel channel) {
    return new BuildingEnvControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BuildingEnvControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BuildingEnvControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BuildingEnvControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BuildingEnvControlServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BuildingEnvControlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Unary
     * </pre>
     */
    public void airConditionerChange(smart.building.envControl.ChangeRequest request,
        io.grpc.stub.StreamObserver<smart.building.envControl.ChangeReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAirConditionerChangeMethod(), responseObserver);
    }

    /**
     * <pre>
     *Unary
     * </pre>
     */
    public void humidityCheck(smart.building.envControl.HumidityRequest request,
        io.grpc.stub.StreamObserver<smart.building.envControl.HumidityReply> responseObserver) {
      asyncUnimplementedUnaryCall(getHumidityCheckMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAirConditionerChangeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                smart.building.envControl.ChangeRequest,
                smart.building.envControl.ChangeReply>(
                  this, METHODID_AIR_CONDITIONER_CHANGE)))
          .addMethod(
            getHumidityCheckMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                smart.building.envControl.HumidityRequest,
                smart.building.envControl.HumidityReply>(
                  this, METHODID_HUMIDITY_CHECK)))
          .build();
    }
  }

  /**
   */
  public static final class BuildingEnvControlServiceStub extends io.grpc.stub.AbstractStub<BuildingEnvControlServiceStub> {
    private BuildingEnvControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BuildingEnvControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BuildingEnvControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BuildingEnvControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary
     * </pre>
     */
    public void airConditionerChange(smart.building.envControl.ChangeRequest request,
        io.grpc.stub.StreamObserver<smart.building.envControl.ChangeReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAirConditionerChangeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Unary
     * </pre>
     */
    public void humidityCheck(smart.building.envControl.HumidityRequest request,
        io.grpc.stub.StreamObserver<smart.building.envControl.HumidityReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHumidityCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BuildingEnvControlServiceBlockingStub extends io.grpc.stub.AbstractStub<BuildingEnvControlServiceBlockingStub> {
    private BuildingEnvControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BuildingEnvControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BuildingEnvControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BuildingEnvControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary
     * </pre>
     */
    public smart.building.envControl.ChangeReply airConditionerChange(smart.building.envControl.ChangeRequest request) {
      return blockingUnaryCall(
          getChannel(), getAirConditionerChangeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Unary
     * </pre>
     */
    public smart.building.envControl.HumidityReply humidityCheck(smart.building.envControl.HumidityRequest request) {
      return blockingUnaryCall(
          getChannel(), getHumidityCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BuildingEnvControlServiceFutureStub extends io.grpc.stub.AbstractStub<BuildingEnvControlServiceFutureStub> {
    private BuildingEnvControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BuildingEnvControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BuildingEnvControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BuildingEnvControlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<smart.building.envControl.ChangeReply> airConditionerChange(
        smart.building.envControl.ChangeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAirConditionerChangeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<smart.building.envControl.HumidityReply> humidityCheck(
        smart.building.envControl.HumidityRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHumidityCheckMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AIR_CONDITIONER_CHANGE = 0;
  private static final int METHODID_HUMIDITY_CHECK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BuildingEnvControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BuildingEnvControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AIR_CONDITIONER_CHANGE:
          serviceImpl.airConditionerChange((smart.building.envControl.ChangeRequest) request,
              (io.grpc.stub.StreamObserver<smart.building.envControl.ChangeReply>) responseObserver);
          break;
        case METHODID_HUMIDITY_CHECK:
          serviceImpl.humidityCheck((smart.building.envControl.HumidityRequest) request,
              (io.grpc.stub.StreamObserver<smart.building.envControl.HumidityReply>) responseObserver);
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

  private static abstract class BuildingEnvControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BuildingEnvControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smart.building.envControl.BuildingEnvControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BuildingEnvControlService");
    }
  }

  private static final class BuildingEnvControlServiceFileDescriptorSupplier
      extends BuildingEnvControlServiceBaseDescriptorSupplier {
    BuildingEnvControlServiceFileDescriptorSupplier() {}
  }

  private static final class BuildingEnvControlServiceMethodDescriptorSupplier
      extends BuildingEnvControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BuildingEnvControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BuildingEnvControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BuildingEnvControlServiceFileDescriptorSupplier())
              .addMethod(getAirConditionerChangeMethod())
              .addMethod(getHumidityCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
