package com.example.microservicesubscribe.service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class DummyService {
    final SubscriptionService subscriptionService;

    public DummyService(SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    public String weaveString(String username, String suffix){
        subscriptionService.subscribe(username+"@"+suffix);
        return username+"@"+suffix;
    }

    public void testFuture(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            // Override Supplier.get()
            return "computed result";
        }, executor);

        // CompletableFuture Chain: .thenApply()
        CompletableFuture<String> contFuture = future.thenApply(String::toUpperCase)
                .exceptionally(ex->{
                    System.out.println(ex);
                    return "Result when Exception happened.";
                });
        // Terminators: .thenRun()   .thenAccept()

        if (contFuture.isDone()) {
            // Difference between .get() and .join()
            System.out.println(contFuture.join());
            try {
                System.out.println(contFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }else{
            // Manually complete and return
            contFuture.complete("Manually Completed");
        }
    }

    public void testOptional(){
        /* Create Optional */
        Optional<String> optional = Optional.of("A String");
        Optional<String> optionalN = Optional.ofNullable(null);
        /* Check Content */
        if (optional.isPresent()) {
            System.out.println(optional.get());;
        }
        if(optionalN.isEmpty()){
            System.out.println(optionalN.orElse("Default Value"));
        };
        /* Other Operations */
        Optional<Integer> mappingOptional = optional.map(String::length);
        mappingOptional.ifPresent(value->{
            System.out.println("Length: "+value);
        });
    }
}
