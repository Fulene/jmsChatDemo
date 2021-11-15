package com.perso.JmsChat.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class Message implements Serializable {
    private String source;
    private String message;
}
