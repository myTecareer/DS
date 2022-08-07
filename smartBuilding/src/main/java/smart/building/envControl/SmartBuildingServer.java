package smart.building.envControl;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
//import smart.building.ChangeReply;
//import smart.building.ChangeRequest;
import smart.building.envControl.BuildingEnvControlServiceGrpc.BuildingEnvControlServiceImplBase;

public class SmartBuildingServer extends  BuildingEnvControlServiceImplBase{

	public static void main(String[] args) {
		SmartBuildingServer smartBuildingServer = new SmartBuildingServer();
		
		smartBuildingServer.registerService();
		int port = 50071;
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(smartBuildingServer)
					.build()
					.start();
			System.out.println("SmartBuilding Server started, listening on " + port);
			server.awaitTermination();
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void registerService() {
		try {
			//create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			//register a service
			ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "envControl", 50071, "env control service");
			jmdns.registerService(serviceInfo);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void humidityCheck(HumidityRequest request, 
			StreamObserver<HumidityReply> responseObserver) {
		System.out.println("receining Humidity check request: " + request.getStatus());
		String msg = "";
		if(request.getStatus().equalsIgnoreCase("increased")) {
			msg = "Air humidity has been "+request.getStatus()+" by "+request.getFigure()+"%";
		}
		else {
			msg = "Air humidity has been "+request.getStatus()+" by "+request.getFigure()+"%";
			
		}
		HumidityReply reply = HumidityReply.newBuilder().setMessage(msg).build();
		  responseObserver.onNext(reply);

	      responseObserver.onCompleted();
	}
	public void airConditionerChange(ChangeRequest request,
			StreamObserver<ChangeReply> responseObserver ) {
		System.out.println("receiving Air conditioner change request: Turn "+request.getStatus());
		String msg = "ok ";
		if(request.getStatus().equalsIgnoreCase("on")) {
			msg = "Air conditioner already turn on.";
		}
		if(request.getStatus().equalsIgnoreCase("off")) {
			msg = "Air conditioner already turn off.";
		}
		ChangeReply reply = ChangeReply.newBuilder().setMessage(msg).build();
		  responseObserver.onNext(reply);

	      responseObserver.onCompleted();
	}
	
	
	
}
