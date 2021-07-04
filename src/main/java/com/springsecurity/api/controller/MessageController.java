package com.springsecurity.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payload.request.SendMessageRequest;
import payload.response.MessageResponse;

import javax.validation.Valid;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/message")
public class MessageController {
    
    @PostMapping("/send")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> sendMessage(@Valid @RequestBody SendMessageRequest sendMessageRequest) {
        return ResponseEntity.ok(new MessageResponse("Message sent successfully!"));
    }

}