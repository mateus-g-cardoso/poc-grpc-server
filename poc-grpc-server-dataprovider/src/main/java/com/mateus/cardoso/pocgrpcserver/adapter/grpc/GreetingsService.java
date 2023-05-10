package com.mateus.cardoso.pocgrpcserver.adapter.grpc;

import com.mateus.cardoso.grpc.lib.GreetingRequest;
import com.mateus.cardoso.grpc.lib.GreetingResponse;
import com.mateus.cardoso.grpc.lib.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingsService extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);


        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
            .setMessage("Received your " + message + ". Hello From Server. ")
            .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
