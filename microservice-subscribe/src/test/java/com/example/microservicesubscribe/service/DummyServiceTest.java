package com.example.microservicesubscribe.service;

import com.example.microservicesubscribe.http.Response;
import com.example.microservicesubscribe.service.DummyService;
import com.example.microservicesubscribe.service.SubscriptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DummyServiceTest {
    DummyService dummyService;

    @Mock
    SubscriptionService subscriptionService;

    @BeforeEach
    void setUp() {
        dummyService = new DummyService(subscriptionService);
    }

    @Test
    void testWeaveString() {
        // Mocking the behavior of the subscriptionService
        when(subscriptionService.subscribe("abc@gmail.com"))
                .thenReturn(new Response(true, "Successfully Subscribed."));

        assertEquals("abc@gmail.com", dummyService.weaveString("abc", "gmail.com"));
        verify(subscriptionService).subscribe("abc@gmail.com");
    }
}
