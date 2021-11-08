package com.perso.JmsChat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UiChatApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JMS chat demo");
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        Label codeLabel = new Label("Code :");
        codeLabel.setTextFill(Color.WHITE);
        codeLabel.setPadding(new Insets(3));
        TextField codeTextField = new TextField("C1");
        codeTextField.setPromptText("Code");

        Label hostLabel = new Label("Host :");
        hostLabel.setTextFill(Color.WHITE);
        hostLabel.setPadding(new Insets(3));
        TextField hostTextField = new TextField("localhost");
        hostTextField.setPromptText("Host");

        Label portLabel = new Label("Port :");
        portLabel.setTextFill(Color.WHITE);
        portLabel.setPadding(new Insets(3));
        TextField portTextField = new TextField("61617");
        portTextField.setPromptText("Port");

        Button connectionBtn = new Button("Connexion");

        hBox.getChildren().add(codeLabel);
        hBox.getChildren().add(codeTextField);
        hBox.getChildren().add(hostLabel);
        hBox.getChildren().add(hostTextField);
        hBox.getChildren().add(portLabel);
        hBox.getChildren().add(portTextField);
        hBox.getChildren().add(connectionBtn);

        borderPane.setTop(hBox);

        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
