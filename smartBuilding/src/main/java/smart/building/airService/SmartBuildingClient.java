package smart.building.airService;

import java.util.Random;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import smart.building.airService.AirServiceGrpc.AirServiceBlockingStub;
import smart.building.airService.AirServiceGrpc.AirServiceStub;

public class SmartBuildingClient {
	private static AirServiceBlockingStub blockingStub;
	private static AirServiceStub asyncStub;
	public static void main(String[] args) throws Exception{
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50072)
				.usePlaintext()
				.build();
		
		blockingStub = AirServiceGrpc.newBlockingStub(channel);
		asyncStub = AirServiceGrpc.newStub(channel);
		
		System.out.println("currAirQuality method START===");
		currAirQuality();
		
		System.out.println("openCloseAirPurifier method START===");
		openCloseAirPurifier();
		
		channel.shutdown();
		
	}
	public static void openCloseAirPurifier() {
		// TODO Auto-generated method stub
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
						
					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						System.out.println("server completed.");
					}
				
			
				};
				
				StreamObserver<AirPuriRequest> requestObserver = asyncStub.openCloseAirPurifier(responseObserver);
				try {
					requestObserver.onNext(AirPuriRequest.newBuilder().setVal("pm2.5").setFigure(150).build());
					requestObserver.onNext(AirPuriRequest.newBuilder().setVal("pm2.5").setFigure(200).build());
					//requestObserver.onNext(AirPuriRequest.newBuilder().
					
					System.out.println("sending message");
					
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
		StreamObserver<CurrentAirReply> responseObserver = new StreamObserver<CurrentAirReply>() {
			
			@Override
			public void onNext(CurrentAirReply value) {
				// TODO Auto-generated method stub
				//System.out.println("currAirQuality method START===client3");
				//System.out.println("receiving item " + value.getMessage());
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
				//System.out.println("currAirQuality method START===client4");
				System.out.println("stream is completed...receiving currAirQuality method.");
				
			}
			
		};
		
		StreamObserver<CurrentAirRequest> requestObserve = asyncStub.currAirQuality(responseObserver);
		
		try {
			requestObserve.onNext(CurrentAirRequest.newBuilder().setItem("PM2.5").build());
			requestObserve.onNext(CurrentAirRequest.newBuilder().setItem("CO").build());
			requestObserve.onNext(CurrentAirRequest.newBuilder().setItem("CO2").build());
			
			//System.out.println("currAirQuality method START===client2");
			System.out.println("sending items.");
			//successfully stream completion
			requestObserve.onCompleted();
			
			Thread.sleep(new Random().nextInt(1000) + 500);
			
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
