// Name of the package where all the generated files are present.
package smart.building.healthCheckService;
//required java packages for the program.
import java.util.Iterator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import smart.building.healthCheckService.HealthCheckServiceGrpc.HealthCheckServiceBlockingStub;
import smart.building.healthCheckService.HealthCheckServiceGrpc.HealthCheckServiceStub;
//Client need not to extend any other class (GRPC related code) here
public class SmartBuildingClient {
	// Creating stubs for establishing the connection with server.
	// Blocking stub
	private static HealthCheckServiceBlockingStub blockingStub;
	// Async stub
	private static HealthCheckServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception{
		// First a channel is being created to the server from client. Here, we provide the server name (localhost) and port (50057).
		// As it is a local demo of GRPC, we can have non-secured channel (usePlaintext).
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50073)
				.usePlaintext()
				.build();
	//stubs -- generate from proto
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
//rpc method 
	//server streaming
	public static void harmfulAirCheckAsync() {
		// TODO Auto-generated method stub
		// First creating a request message. Here, the message contains a string in setItem
			AirAlarmRequest request = AirAlarmRequest.newBuilder().setItem("start check harmful air").build();
			// Handling the stream from server using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
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
			// Here, we are calling the Remote harmfulAirAlarm method. On receiving the message from server the onNext, onError, onCompleted will be called (as defined above). 
				asyncStub.harmfulAirAlarm(request, responseObserver);
			try {
				Thread.sleep(10000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	//rpc method 
		//server streaming
	public static void buildingCheckBlocking() {
		// TODO Auto-generated method stub
		// First creating a request message. Here, the message contains a string in setItem
			BuildingAirRequest request = BuildingAirRequest.newBuilder().setItem("start check room's condition").build();
		try {
			//iterating each message in replies when calling remote 'buildingAirConditionCheck' rpc method.
			Iterator<BuildingAirReply> replies = blockingStub.buildingAirConditionCheck(request);
			// Client keeps a check on the next message in stream.
				while(replies.hasNext()) {
				BuildingAirReply temp = replies.next();
				System.out.println(temp.getMessage());
			}
		}catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
	}
}
