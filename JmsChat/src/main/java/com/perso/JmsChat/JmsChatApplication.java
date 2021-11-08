package com.perso.JmsChat;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsChatApplication {

	public static void main(String[] args) {
		Application.launch(UiChatApplication.class, args);
	}

}
