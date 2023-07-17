package com.example.microserviceconversation.dao;

import com.example.microserviceconversation.bean.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConversationDao extends JpaRepository<Conversation, Integer> {
    @Query("SELECT c FROM Conversation c WHERE c.userId=:userId ORDER BY c.updateTime DESC")
    List<Conversation> findAllByUserIdOrOrderByUpdateTimeDesc(@Param("userId")int userId);

    @Query("SELECT c FROM Conversation c WHERE c.status = :status ORDER BY c.updateTime DESC")
    List<Conversation> findAllByStatus(@Param("status") String status);
}
