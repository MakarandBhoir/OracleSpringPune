package com.oracle.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String destination, String message) {
        System.out.println("Sending message: " + message);
        jmsTemplate.convertAndSend(destination, message);
    }
}