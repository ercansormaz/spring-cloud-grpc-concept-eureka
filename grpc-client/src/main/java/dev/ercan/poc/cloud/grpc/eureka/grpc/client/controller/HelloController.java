package dev.ercan.poc.cloud.grpc.eureka.grpc.client.controller;

import dev.ercan.poc.cloud.grpc.eureka.grpc.client.service.HelloServiceGrpcClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
public class HelloController {

  private final HelloServiceGrpcClient helloServiceGrpcClient;

  @GetMapping
  public ResponseEntity<String> sayHello(@RequestParam String name) {
    return ResponseEntity.ok(helloServiceGrpcClient.sayHello(name));
  }

}
