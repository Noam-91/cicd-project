package com.example.microserviceconversation.controller;

import com.example.microserviceconversation.bean.Conversation;
import com.example.microserviceconversation.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/conversation")
public class ConversationController {
    @Autowired
    ConversationService conversationService;

    @PostMapping("/create")
    public ResponseEntity<?> createConversation(@RequestBody Conversation conversation){
        return ResponseEntity.ok(conversationService.createConversation(conversation));
    }

    @GetMapping("/{userId}/all")
    public ResponseEntity<?> getAllConversationByUserId(@PathVariable int userId,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "6") int size,
                                         @RequestParam(defaultValue = "updateTime") String sortBy,
                                         @RequestParam(defaultValue = "desc") String sortDirection){
        List<Conversation> conversationList = conversationService.getAllConversationByUserId(userId);
        return ResponseEntity.ok(conversationList);
    }

    @GetMapping("/active")
    public ResponseEntity<?> getAllActiveConversation(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "6") int size){
        String sortBy="updateTime";
        String sortDirection="desc";
        return ResponseEntity.ok(conversationService.getAllActiveConversation());
    }

    @GetMapping("/{conversationId}")
    public ResponseEntity<?> getConversationById(@PathVariable int conversationId){
        return ResponseEntity.ok(
                Objects.requireNonNullElse(conversationService.getConversationById(conversationId),
                "Conversation not found."));
    }

    @PutMapping("/{conversationId}")
    public ResponseEntity<?> closeConversation(@PathVariable int conversationId){
        int page = 0;
        int size = 6;
        String sortBy="updateTime";
        String sortDirection="desc";
        return ResponseEntity.ok(conversationService.closeConversation(conversationId));
    }


}
