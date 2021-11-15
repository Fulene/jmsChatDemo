package com.perso.JmsChat.controller;

import com.perso.JmsChat.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    private final static String QUEUE = "chat-queue";

    @Autowired
    JmsTemplate jmsTemplate;


    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody String message) {
        try {
            jmsTemplate.convertAndSend(QUEUE, message);
            return new ResponseEntity<>("Sent", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
