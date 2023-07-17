package com.example.microservicemessage.controller;

import com.example.microservicemessage.bean.Message;
import com.example.microservicemessage.http.Response;
import com.example.microservicemessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/{conversationId}")
    public ResponseEntity<List<Message>> getAllMessagesInConversation(@PathVariable int conversationId){
        return ResponseEntity.ok(messageService.getAllMessagesInConversation(conversationId));
    }

    @PostMapping("/add_message/{conversationId}")
    public Response addMessage(@PathVariable int conversationId, @RequestBody Message message){
        return messageService.addMessage(conversationId, message);
    }
}
