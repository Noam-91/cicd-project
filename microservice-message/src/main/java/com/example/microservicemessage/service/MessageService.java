package com.example.microservicemessage.service;

import com.example.microservicemessage.bean.Message;
import com.example.microservicemessage.dao.MessageDao;
import com.example.microservicemessage.dto.Conversation;
import com.example.microservicemessage.http.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageDao messageDao;
    @Autowired
    WebClient.Builder webClientBuilder;

    private final ObjectMapper mapper = new ObjectMapper();

    public List<Message> getAllMessagesInConversation(int conversationId){
        System.out.println("1");
        return messageDao.findAllByConversationId(conversationId);
    }

    @Transactional
    public Response addMessage(int conversationId, Message message){
        JsonNode jsonNode = webClientBuilder.build()
                .get()
                .uri("http://conversation-service/conversation/"+conversationId)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
        JsonNode jsonNodeTest = webClientBuilder.build()
                .get()
                .uri("http://subscribe-service/subscriptions/")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        Conversation conversation = mapper.convertValue(jsonNode,Conversation.class);
        if (conversation==null){
            return new Response(false,"Conversation DNE");
        }
//        messageDao.save(message);
        return new Response(true,"New message added.");
    }

}
