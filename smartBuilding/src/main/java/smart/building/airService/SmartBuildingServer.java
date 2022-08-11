//all airService file are generated here.
package smart.building.airService;
//required java packages for the program
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.building.airService.AirServiceGrpc.AirServiceImplBase;
//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class SmartBuildingServer extends AirServiceImplBase{

	public static void main(String[] args) {
		// The smartBuildingServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
		SmartBuildingServer smartBuildingServer = new SmartBuildingServer();
		//register the service
		smartBuildingServer.registerService();
		
		//this port number where server will be listen to
		int port = 50072;
		try {
			//create a server
			Server server = ServerBuilder.forPort(port)//listen to 50072
					.addService(smartBuildingServer)//this smartBuildingServer service
					.build()//build
					.start();//start
			//System.out.println("currAirQuality method START===server1");
			System.out.println("SmartBuilding Server started, listening on "+port );
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
			ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "airService", 50072, "air quality and purifier control service");
			jmdns.registerService(serviceInfo);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	//rpc method 
	//client streaming
	public StreamObserver<CurrentAirRequest> currAirQuality(
			StreamObserver<CurrentAirReply> responseObserver){
		// Retrieve the value from the stream of requests of the client. 
			return new StreamObserver<CurrentAirRequest> () {

			ArrayList<String> list = new ArrayList<>();
			@Override
			// For each message in the stream, get one stream at a time.
				public void onNext(CurrentAirRequest value) {
				// TODO Auto-generated method stub
				// get value of client input for each message in the stream. 
				System.out.println("receiving Air item: " +value.getItem());
				//add them into the arraylist
				list.add(value.getItem());
				
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}
			// Once the complete stream is received this logic will be executed.
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("receiving currAirQuality method completed \n");
				String currAir = "Item: ";
				for(String s: list) {
					currAir += s ;
				}
				currAir = currAir +  " being monitored";
				// Preparing and sending the reply for the client. Here, response is build and with the value (currAir) computed by above logic.
				 // Here, response is sent once the client is done with sending the stream.
				CurrentAirReply reply = CurrentAirReply.newBuilder().setMessage(currAir ).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
			
		};//return statement, don't forget ";"
	}
	//2nd rpc method
	//Bi-Directional Streaming
	public StreamObserver<AirPuriRequest> openCloseAirPurifier (
			StreamObserver<AirPuriReply> responseObserver){
				return new StreamObserver<AirPuriRequest>() {
					// For each message in the stream, get one stream at a time.
					@Override
					public void onNext(AirPuriRequest value) {
						// TODO Auto-generated method stub
						// In bidirectional stream, both server and  client would be sending the stream of messages.
						// Here, for each message in stream from client, server is sending back one response.
						System.out.println("receiving openCloseAirPurifier method: " + value.getVal());
						String pmCheck = value.getVal();
						String msg = "";
						if (pmCheck.equalsIgnoreCase("pm2.5")) {
							if(value.getFigure()<= 180) {
								msg = pmCheck+" level in the air is: "+value.getFigure()+", it's within the healthy range and the purifier remains off";
							}
							else {
								msg = pmCheck+" level in the air is: "+value.getFigure()+", it's exceeds healthy range and the purifier is on";
								
							}
						}
					    // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
						AirPuriReply reply = AirPuriReply.newBuilder().setMessage(msg).build();
						
						responseObserver.onNext(reply);
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						t.printStackTrace();
					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						responseObserver.onCompleted();
					}
					
				};
		
	}
	
}
