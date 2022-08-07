package smart.building.envControl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
//import smart.building.ChangeReply;
//import smart.building.ChangeRequest;
import smart.building.envControl.BuildingEnvControlServiceGrpc.BuildingEnvControlServiceBlockingStub;
import smart.building.envControl.BuildingEnvControlServiceGrpc.BuildingEnvControlServiceStub;

public class SmartBuildingClient {
	private static BuildingEnvControlServiceBlockingStub blockingStub;
	private static BuildingEnvControlServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception{
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50071)
				.usePlaintext()
				.build();
		
		blockingStub = BuildingEnvControlServiceGrpc.newBlockingStub(channel);
		asyncStub = BuildingEnvControlServiceGrpc.newStub(channel);
		
		System.out.println("air conditionar method start====");
		airConditionerChange();
		
		System.out.println("humidity change method start====");
		humidityChange();
		
		channel.shutdown();
	}

	public static void humidityChange() {
		// TODO Auto-generated method stub
		HumidityRequest request = HumidityRequest.newBuilder().setStatus("increased").setFigure(10).build();
		HumidityReply reply = blockingStub.humidityCheck(request);
		System.out.println("reply: "+ reply.getMessage());
	
	}

	private static void airConditionerChange() {
		// TODO Auto-generated method stub
		String status = "on";
		ChangeRequest request = ChangeRequest.newBuilder().setStatus(status).build();
		ChangeReply reply = blockingStub.airConditionerChange(request);
		System.out.println("reply: "+ reply.getMessage() );
	}
	
	
	
}
