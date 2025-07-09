package com.oracle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oracle.config.AppConfig;
import com.oracle.service.EmailService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, EmailService.class);
        EmailService emailService = context.getBean(EmailService.class);

        emailService.sendSimpleEmail(
                "makarand.training@gmail.com", 
                "Spring Mail Test", 
                "Hello from Spring Mail without Spring Boot!"
        );
	}
}