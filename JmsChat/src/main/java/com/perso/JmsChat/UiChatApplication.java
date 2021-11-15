package com.perso.JmsChat;

import com.perso.JmsChat.consumer.ChatService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
public class UiChatApplication extends Application {

    @Autowired
    private JmsTemplate jmsTemplate;

    private ConfigurableApplicationContext applicationContext;
    private ChatService chatService;

    @Override
    public void init() {
        applicationContext = SpringApplication.run(JmsChatApplication.class);
        chatService = applicationContext.getBean(ChatService.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JMS chat demo");
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        Label codeLabel = new Label("Code du destinataire :");
        codeLabel.setTextFill(Color.WHITE);
        codeLabel.setPadding(new Insets(3));
        TextField codeTextField = new TextField("C1");
        codeTextField.setPromptText("Code");

        Label messageLabel = new Label("message :");
        messageLabel.setTextFill(Color.WHITE);
        messageLabel.setPadding(new Insets(3));
        TextArea messageTextField = new TextArea();
        messageTextField.setPrefRowCount(2);
        messageTextField.setPrefColumnCount(20);
        Button sendBtn = new Button("Envoyer");

        hBox.getChildren().add(codeLabel);
        hBox.getChildren().add(codeTextField);
        hBox.getChildren().add(messageLabel);
        hBox.getChildren().add(messageTextField);
        hBox.getChildren().add(sendBtn);

        borderPane.setTop(hBox);

        Scene scene = new Scene(borderPane, 800, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        sendBtn.setOnAction(event -> {
            chatService.sendMessage(messageTextField.getText());
        });
    }

    @Override
    public void stop() {
        applicationContext.stop();
        Platform.exit();
    }
}
