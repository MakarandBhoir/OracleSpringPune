package com.oracle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
    	
    	GreetingService service = context.getBean(GreetingService.class);
    	String greeting = service.greet("World");
    	System.out.println(greeting);
    }
}
