package dev.ercan.poc.cloud.grpc.eureka.grpc.server.service;

import dev.ercan.poc.cloud.grpc.eureka.lib.HelloRequest;
import dev.ercan.poc.cloud.grpc.eureka.lib.HelloResponse;
import dev.ercan.poc.cloud.grpc.eureka.lib.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Value;

@GrpcService
public class HelloGrpcService extends HelloServiceImplBase {

  @Value("${eureka.instance.instance-id}")
  private String instanceId;

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    HelloResponse response = HelloResponse.newBuilder()
        .setMessage("Hello " + request.getName() + " from " + instanceId)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
