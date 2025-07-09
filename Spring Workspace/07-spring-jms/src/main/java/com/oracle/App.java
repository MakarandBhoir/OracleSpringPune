package com.oracle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oracle.config.AppConfig;
import com.oracle.jms.MessageSender;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender sender = context.getBean(MessageSender.class);
        sender.send("testQueue", "Hello from Spring JMS!");

        // Give some time for message listener to consume
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        context.close();
	}
}