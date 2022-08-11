// Name of the package where all the generated files are present.
package smart.building.envControl;
//required java packages for the program
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import smart.building.envControl.BuildingEnvControlServiceGrpc.BuildingEnvControlServiceBlockingStub;
import smart.building.envControl.BuildingEnvControlServiceGrpc.BuildingEnvControlServiceStub;

public class SmartBuildingClient {
	// Creating stubs for establishing the connection with server.
	// Blocking stub
	private static BuildingEnvControlServiceBlockingStub blockingStub;
	// asyncStub
	private static BuildingEnvControlServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception{
		// First a channel is being created to the server from client. Here, we provide the server name (localhost) and port (50058).
	ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50071)
				.usePlaintext()
				.build();
	//these stubs are generated from proto	
		blockingStub = BuildingEnvControlServiceGrpc.newBlockingStub(channel);
		asyncStub = BuildingEnvControlServiceGrpc.newStub(channel);
		//use blockingStub
		//unary
		System.out.println("air conditionar method start====");
		airConditionerChange();
		//use blockingStub
		//unary
		System.out.println("humidity change method start====");
		humidityChange();
		// Closing the channel once message has been passed.
		channel.shutdown();
	}

	public static void humidityChange() {
		// TODO Auto-generated method stub
		// First creating a request message. Here, the message contains a string and a figure in setStatus
		HumidityRequest request = HumidityRequest.newBuilder().setStatus("increased").setFigure(10).build();
	//  Calling a remote RPC method using blocking stub defined in main method. request is the message we want to pass.
		HumidityReply reply = blockingStub.humidityCheck(request);
		//response contains the output from the server side. Here, we are printing the value contained by response. 
			System.out.println("reply: "+ reply.getMessage());
	
	}

	private static void airConditionerChange() {
		// TODO Auto-generated method stub
		String status = "on";
		// First creating a request message. Here, the message contains a string  in setStatus
		ChangeRequest request = ChangeRequest.newBuilder().setStatus(status).build();
	//  Calling a remote RPC method using blocking stub defined in main method. request is the message we want to pass.
		ChangeReply reply = blockingStub.airConditionerChange(request);
		//response contains the output from the server side. Here, we are printing the value contained by response. 
		System.out.println("reply: "+ reply.getMessage() );
	}
	
	
	
}
