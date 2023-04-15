package dev.ercan.poc.cloud.grpc.eureka.grpc.client.service;

import dev.ercan.poc.cloud.grpc.eureka.lib.HelloRequest;
import dev.ercan.poc.cloud.grpc.eureka.lib.HelloResponse;
import dev.ercan.poc.cloud.grpc.eureka.lib.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceGrpcClient {

  @GrpcClient("hello-service")
  private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

  public String sayHello(String name) {
    HelloRequest request = HelloRequest.newBuilder()
        .setName(name)
        .build();

    HelloResponse response = helloServiceBlockingStub.sayHello(request);

    return response.getMessage();
  }

}
