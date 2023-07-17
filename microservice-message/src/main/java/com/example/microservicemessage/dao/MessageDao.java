package com.example.microservicemessage.dao;

import com.example.microservicemessage.bean.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDao extends JpaRepository<Message, Integer> {
    List<Message> findAllByConversationId(int conversationId);
}
