package com.example.microservicesubscribe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceSubscribeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSubscribeApplication.class, args);
    }

}
