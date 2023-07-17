package com.example.microserviceconversation.service;

import com.example.microserviceconversation.bean.Conversation;
import com.example.microserviceconversation.dao.ConversationDao;
import com.example.microserviceconversation.shared.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ConversationService {
    @Autowired
    ConversationDao conversationDao;
    @Autowired
    WebClient webClient;

    public List<Conversation> createConversation(Conversation conversation){
        conversation.setStatus(Constants.CONVERSATION_STATUS_ACTIVE);
        conversationDao.save(conversation);
        return getAllConversationByUserId(conversation.getUserId());
    }

    public List<Conversation> getAllConversationByUserId(int userId){
        return Objects.requireNonNullElse(conversationDao.findAllByUserIdOrOrderByUpdateTimeDesc(userId),
                new ArrayList<>());
    }

    public List<Conversation> getAllActiveConversation(){
        return Objects.requireNonNullElse(conversationDao.findAllByStatus(Constants.CONVERSATION_STATUS_ACTIVE),
                new ArrayList<>());
    }

    public Conversation getConversationById(int conversationId){
        Conversation conversation = conversationDao.findById(conversationId).orElse(null);
        return conversation;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<Conversation> closeConversation(int conversationId){
        try {
            Conversation conversation = getConversationById(conversationId);
            conversation.setStatus(Constants.CONVERSATION_STATUS_CLOSED);
            conversationDao.save(conversation);
            return getAllConversationByUserId(conversation.getUserId());
        } catch (Exception e) {
            return null;
        }

    }

}
