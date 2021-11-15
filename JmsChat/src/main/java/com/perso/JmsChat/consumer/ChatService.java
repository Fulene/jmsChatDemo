package com.perso.JmsChat.consumer;

import com.perso.JmsChat.model.Message;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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

    ObservableList<String> messageReceivedList;

    @JmsListener(destination = QUEUE)
    public void messageListener(Message message) {
        log.info("message received : {}", message);
        Platform.runLater(() -> {
            messageReceivedList.add(message.toString());
        });
    }

    public void sendMessage(Message message) {
        jmsTemplate.convertAndSend(QUEUE, message);
    }

    public void setMessageReceivedList(ObservableList<String> messageReceivedList) {
        this.messageReceivedList = messageReceivedList;
    }
}
