package com.example.microservicesubscribe.service;

import com.example.microservicesubscribe.bean.Subscription;
import com.example.microservicesubscribe.dao.SubscriptionDao;
import com.example.microservicesubscribe.http.Response;
import com.example.microservicesubscribe.shared.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionDao subscriptionDao;

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Response subscribe(String email){
        try {
            Subscription subscription = subscriptionDao.findByEmail(email);
            if (subscription==null){
                subscription = new Subscription(email, Constants.SUBSCRIPTION_STATUS_ACTIVE);
                subscriptionDao.save(subscription);
            }else {
                subscription.setStatus(Constants.SUBSCRIPTION_STATUS_ACTIVE);
            }
            return new Response(true, "Successfully Subscribed.");
        } catch (Exception e) {
            return new Response(false, "Subscription failed.");
        }

    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Response unsubscribe(String email){
        try {
            Subscription subscription = subscriptionDao.findByEmail(email);
            subscription.setStatus(Constants.SUBSCRIPTION_STATUS_INACTIVE);
            subscriptionDao.save(subscription);
            return new Response(true, "Successfully Subscribed.");
        } catch (Exception e) {
            return new Response(false, "Subscription failed.");
        }
    }

    public List<Subscription> getAllActiveSubs(){
        return subscriptionDao.findAllActiveSubs();
    }


}
