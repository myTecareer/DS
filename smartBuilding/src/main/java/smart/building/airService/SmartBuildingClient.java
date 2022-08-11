// Name of the package where all the generated files are present.
package smart.building.airService;
//required java packages for the program
import java.util.Random;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import smart.building.airService.AirServiceGrpc.AirServiceBlockingStub;
import smart.building.airService.AirServiceGrpc.AirServiceStub;
//Client need not to extend any other class (GRPC related code) here
public class SmartBuildingClient {
	// Creating stubs for establishing the connection with server.
	// Blocking stub
	private static AirServiceBlockingStub blockingStub;
	// asyncStub
	private static AirServiceStub asyncStub;
	public static void main(String[] args) throws Exception{
		// First a channel is being created to the server from client. Here, we provide the server name (localhost) and port (50058).

	ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50072)
				.usePlaintext()
				.build();
		//these stubs are generated from proto
		blockingStub = AirServiceGrpc.newBlockingStub(channel);
		asyncStub = AirServiceGrpc.newStub(channel);
		//use asyncStub
		//Client Streaming
		System.out.println("currAirQuality method START===");
		currAirQuality();
		//Bi-Directional Streaming
		System.out.println("openCloseAirPurifier method START===");
		openCloseAirPurifier();
		// Closing the channel once message has been passed.
		channel.shutdown();
		
	}
	public static void openCloseAirPurifier() {
		// TODO Auto-generated method stub
		// Handling the server stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
		StreamObserver<AirPuriReply> responseObserver = 
				new StreamObserver<AirPuriReply>() {

					@Override
					public void onNext(AirPuriReply value) {
						// TODO Auto-generated method stub
						System.out.println("received is " + value.getMessage());
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						t.printStackTrace();
					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						System.out.println("server completed.");
					}
				
			
				};
				// Here, we are calling the Remote openCloseAirPurifier method. Using onNext, client sends a stream of messages.
				StreamObserver<AirPuriRequest> requestObserver = asyncStub.openCloseAirPurifier(responseObserver);
				try {
					requestObserver.onNext(AirPuriRequest.newBuilder().setVal("pm2.5").setFigure(150).build());
					requestObserver.onNext(AirPuriRequest.newBuilder().setVal("pm2.5").setFigure(200).build());
					
					System.out.println("sending message");
					// Mark the end of requests
					requestObserver.onCompleted();
					//sleep for a while before sending the next one
					Thread.sleep(new Random().nextInt(2000) + 500);
				} catch(RuntimeException e) {
					e.printStackTrace();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				
	}
	public static void currAirQuality() {
		// TODO Auto-generated method stub
		// Handling the stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
		StreamObserver<CurrentAirReply> responseObserver = new StreamObserver<CurrentAirReply>() {
			
			@Override
			public void onNext(CurrentAirReply value) {
				// TODO Auto-generated method stub
				System.out.println("currAirQuality method STARTclient3 " + value.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("stream is completed...receiving currAirQuality method.");
				
			}
			
		};
		// Here, we are calling the Remote currAirQuality method. Using onNext, client sends a stream of messages.
			StreamObserver<CurrentAirRequest> requestObserve = asyncStub.currAirQuality(responseObserver);
		
		try {
			requestObserve.onNext(CurrentAirRequest.newBuilder().setItem("PM2.5").build());
			requestObserve.onNext(CurrentAirRequest.newBuilder().setItem("CO").build());
			requestObserve.onNext(CurrentAirRequest.newBuilder().setItem("CO2").build());
			
			System.out.println("sending items.");
			//successfully stream completion
			requestObserve.onCompleted();
			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);
			
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
