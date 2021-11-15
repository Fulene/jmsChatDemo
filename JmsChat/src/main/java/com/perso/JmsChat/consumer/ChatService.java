package com.perso.JmsChat.consumer;

import com.perso.JmsChat.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class ChatService {

    private final static String QUEUE = "chat-queue";

    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = QUEUE)
    public void messageListener(String message) throws UnsupportedEncodingException {
        log.info("message received : {}", message);
    }

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(QUEUE, message);
    }

}
