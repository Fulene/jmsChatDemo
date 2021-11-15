package com.perso.JmsChat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class Message implements Serializable {
    private String source;
    private String recipient;
    private String message;

    public String toString() {
        return "[Source : " + source + ", Dest : " + recipient + ", Message : " + message + "]";
    }
}
