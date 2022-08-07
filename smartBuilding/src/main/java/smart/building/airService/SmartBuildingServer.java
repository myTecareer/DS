package smart.building.airService;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.building.airService.AirServiceGrpc.AirServiceImplBase;

public class SmartBuildingServer extends AirServiceImplBase{

	public static void main(String[] args) {
		
		SmartBuildingServer smartBuildingServer = new SmartBuildingServer();
		
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
	
	public StreamObserver<CurrentAirRequest> currAirQuality(
			StreamObserver<CurrentAirReply> responseObserver){
		//get the value from the stream of requests of the client
		return new StreamObserver<CurrentAirRequest> () {

			ArrayList<String> list = new ArrayList<>();
			@Override
			//get one at a time
			public void onNext(CurrentAirRequest value) {
				// TODO Auto-generated method stub
				//System.out.println("currAirQuality method START===server2");
				System.out.println("receiving Air item: " +value.getItem());
				list.add(value.getItem());
				
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				//System.out.println("currAirQuality method START===server3");
				System.out.println("receiving currAirQuality method completed \n");
				String currAir = "Item: ";
				for(String s: list) {
					currAir += s ;
				}
				currAir = currAir +  " being monitored";
				
				CurrentAirReply reply = CurrentAirReply.newBuilder().setMessage(currAir ).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
			
		};//return statement, don't forget ";"
	}
	
	public StreamObserver<AirPuriRequest> openCloseAirPurifier (
			StreamObserver<AirPuriReply> responseObserver){
				return new StreamObserver<AirPuriRequest>() {

					@Override
					public void onNext(AirPuriRequest value) {
						// TODO Auto-generated method stub
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
						AirPuriReply reply = AirPuriReply.newBuilder().setMessage(msg).build();
						
						responseObserver.onNext(reply);
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						responseObserver.onCompleted();
					}
					
				};
		
	}
	
}
