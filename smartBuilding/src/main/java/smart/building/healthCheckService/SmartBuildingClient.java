package smart.building.healthCheckService;

import java.util.Iterator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import smart.building.healthCheckService.HealthCheckServiceGrpc.HealthCheckServiceBlockingStub;
import smart.building.healthCheckService.HealthCheckServiceGrpc.HealthCheckServiceStub;

public class SmartBuildingClient {

	private static HealthCheckServiceBlockingStub blockingStub;
	private static HealthCheckServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception{
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50073)
				.usePlaintext()
				.build();
		
		blockingStub = HealthCheckServiceGrpc.newBlockingStub(channel);
		asyncStub = HealthCheckServiceGrpc.newStub(channel);
		
		//rpc call with Blocking stub
		System.out.println("All room's conditions start to check");
		buildingCheckBlocking();
		
		//rpc call with Asynchronous stub
		System.out.println("Harmful Air start to check");
		harmfulAirCheckAsync();
		
		//closing the channel
		channel.shutdown();
	}

	public static void harmfulAirCheckAsync() {
		// TODO Auto-generated method stub
		AirAlarmRequest request = AirAlarmRequest.newBuilder().setItem("start check harmful air").build();
		
			StreamObserver<AirAlarmReply> responseObserver = new StreamObserver<AirAlarmReply>() {

				@Override
				public void onNext(AirAlarmReply value) {
					// TODO Auto-generated method stub
					System.out.println("receiving harmful alarm:"+ value.getMessage());
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Stream is completed");
				}
				
			};
			asyncStub.harmfulAirAlarm(request, responseObserver);
			try {
				Thread.sleep(10000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		
	}

	public static void buildingCheckBlocking() {
		// TODO Auto-generated method stub
		BuildingAirRequest request = BuildingAirRequest.newBuilder().setItem("start check room's condition").build();
		//BuildingAirRequest request = BuildingAirRequest.newBuilder().equals(1).;
		try {
			//iterating each message in replies when calling remote 'buildingAirConditionCheck' rpc method.
			Iterator<BuildingAirReply> replies = blockingStub.buildingAirConditionCheck(request);
			
			while(replies.hasNext()) {
				BuildingAirReply temp = replies.next();
				System.out.println(temp.getMessage());
			}
		}catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
	}
}
