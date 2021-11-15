package com.perso.JmsChat.consumer;

import com.perso.JmsChat.model.Message;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChatService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${activemq.topic-name}")
    private String destinationTopic;

    ObservableList<String> messageReceivedList;
    String personalCode = "C1";

    @JmsListener(destination = "${activemq.topic-name}")
    public void messageListener(Message message) {
        log.info("message received : {}", message);
        Platform.runLater(() -> {
//            if (personalCode.equals(message.getRecipient()))
                messageReceivedList.add(message.getSource() + " : " + message.getMessage());
        });
    }

    public void sendMessage(Message message) {
        jmsTemplate.convertAndSend(destinationTopic, message);
    }

    public void setMessageReceivedList(ObservableList<String> messageReceivedList) {
        this.messageReceivedList = messageReceivedList;
    }

    public void setPersonalCode(String code) {
        personalCode = code;
    }
}
