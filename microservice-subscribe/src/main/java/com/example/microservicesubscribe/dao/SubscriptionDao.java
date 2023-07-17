package com.example.microservicesubscribe.dao;


import com.example.microservicesubscribe.bean.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubscriptionDao extends JpaRepository<Subscription, Integer> {
    @Query("SELECT s FROM Subscription s WHERE s.status = 'active'")
    List<Subscription> findAllActiveSubs();

    @Query("SELECT s FROM Subscription s WHERE s.email = :email")
    Subscription findByEmail(@Param("email") String email);

}
