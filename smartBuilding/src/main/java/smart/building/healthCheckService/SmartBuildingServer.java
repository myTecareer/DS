//all healthCheckService file are generated here.
package smart.building.healthCheckService;
//required java packages for the program
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.building.healthCheckService.HealthCheckServiceGrpc.HealthCheckServiceImplBase;
//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class SmartBuildingServer extends HealthCheckServiceImplBase{

	public static void main(String[] args) {
		// The smartBuildingServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
			SmartBuildingServer smartBuildingServer = new SmartBuildingServer();
			//register the service
		smartBuildingServer.registerService();
		//this port number where server will be listen to
		int port = 50073;
		
		try {
			//create a server	
			Server server = ServerBuilder.forPort(port)
					.addService(smartBuildingServer)
					.build()
					.start();
			System.out.println("SmartBuilding Server started, listening on "+port);
			
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
			ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local", "healthCheck", 50073, "health check service");
			jmdns.registerService(serviceInfo);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	//rpc method 
	//Server Streaming
	public void harmfulAirAlarm(AirAlarmRequest request,
			StreamObserver<AirAlarmReply> responseObserver) {
		System.out.println("receiving harmful Air check");
		String[] harmful = {"Dust Mite","Pollen","VOCs","ETS","CO"};
		String msg = "";
		ArrayList<String> harmfulList = new ArrayList<>();
		for(int i = 0; i < harmful.length; i++) {
			if(request.getItem() != null) {
				msg = harmful[i] + " is in safe level.";
				harmfulList.add(msg);
				//System.out.println(msg);
			}
		}
		for(String s: harmfulList) {
			// Preparing and sending the reply for the client. Here, response is build and with the value (s) computed by above logic.
			 // Here, a stream of response is sent using the for loop.
			responseObserver.onNext(AirAlarmReply.newBuilder().setMessage(s).build());
		}
		responseObserver.onCompleted();
	}
	
	
	public void buildingAirConditionCheck(BuildingAirRequest request, 
			StreamObserver<BuildingAirReply> responseObserver) {
		System.out.println("receiving building air condition check");


		String[] roomNo = {"RM01","RM02","RM03","RM04","RM05","RM06","RM07","RM08","RM09","RM10"};
		//Random rnd = new Random();
		String msg = "";
		ArrayList<String> msglist = new ArrayList<>();
		for(int i=0; i< roomNo.length; i++) {
			if(request.getItem() != null) {
				
				msg = roomNo[i] + " condition checked. ";
				msglist.add(msg);
				System.out.println(msg );
			}
		}
		
		for(String s: msglist) {
			// Preparing and sending the reply for the client. Here, response is build and with the value (s) computed by above logic.
			 // Here, a stream of response is sent using the for loop.
		responseObserver.onNext(BuildingAirReply.newBuilder().setMessage(s).build());
		}
		
		responseObserver.onCompleted();
	}
}
