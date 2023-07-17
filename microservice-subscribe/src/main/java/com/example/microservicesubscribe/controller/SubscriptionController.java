package com.example.microservicesubscribe.controller;


import com.example.microservicesubscribe.http.Response;
import com.example.microservicesubscribe.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/{email}")
    public Response subscribe(@PathVariable String email){
        return subscriptionService.subscribe(email);
    }

    @PutMapping("/{email}")
    public Response unsubscribe(@PathVariable String email){
        return subscriptionService.unsubscribe(email);
    }

    @GetMapping
    public ResponseEntity<?> getAllActiveSubs(){
        return ResponseEntity.ok(subscriptionService.getAllActiveSubs());
    }
}
