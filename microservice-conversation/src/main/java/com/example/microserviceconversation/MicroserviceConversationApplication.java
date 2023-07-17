package com.example.microserviceconversation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceConversationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConversationApplication.class, args);
    }

}
