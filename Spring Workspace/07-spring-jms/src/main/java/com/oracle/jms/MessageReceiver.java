package com.oracle.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @JmsListener(destination = "testQueue")
    public void receive(String message) {
        System.out.println("Received message: " + message);
    }
}