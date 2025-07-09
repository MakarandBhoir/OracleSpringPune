package com.oracle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	GreetingService service = context.getBean(GreetingService.class);
    	String greeting = service.greet("World");
    	System.out.println(greeting);
    }
}
