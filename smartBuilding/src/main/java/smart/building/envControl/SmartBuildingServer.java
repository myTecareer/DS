//all airService file are generated here.
package smart.building.envControl;
//required java packages for the program
import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import smart.building.envControl.BuildingEnvControlServiceGrpc.BuildingEnvControlServiceImplBase;
//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class SmartBuildingServer extends  BuildingEnvControlServiceImplBase{

	public static void main(String[] args) {
		// The smartBuildingServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
		SmartBuildingServer smartBuildingServer = new SmartBuildingServer();
		//register the service
		smartBuildingServer.registerService();
		//this port number where server will be listen to
			int port = 50071;
		
		try {
			//create a server
			Server server = ServerBuilder.forPort(port)
					.addService(smartBuildingServer)//this smartBuildingServer service
					.build()//build
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
	//rpc method //unary
	
	public void humidityCheck(HumidityRequest request, 
			StreamObserver<HumidityReply> responseObserver) {
		// Retrieve the value from the request of the client
		System.out.println("receining Humidity check request: " + request.getStatus());
		String msg = "";
		if(request.getStatus().equalsIgnoreCase("increased")) {
			msg = "Air humidity has been "+request.getStatus()+" by "+request.getFigure()+"%";
		}
		else {
			msg = "Air humidity has been "+request.getStatus()+" by "+request.getFigure()+"%";
			
		}
		// Preparing the reply for the client. Here, response is build and with the value (msg) computed by above logic.  
		HumidityReply reply = HumidityReply.newBuilder().setMessage(msg).build();
		// Sending the reply for each request.
	responseObserver.onNext(reply);

	      responseObserver.onCompleted();
	}
	//rpc method //unary
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
		// Preparing the reply for the client. Here, response is build and with the value (msg) computed by above logic.  
		ChangeReply reply = ChangeReply.newBuilder().setMessage(msg).build();
		// Sending the reply for each request. 
		responseObserver.onNext(reply);

	      responseObserver.onCompleted();
	}
	
	
	
}
