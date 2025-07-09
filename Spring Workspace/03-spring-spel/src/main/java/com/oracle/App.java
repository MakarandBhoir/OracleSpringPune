package com.oracle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oracle.config.AppConfig;
import com.oracle.spel.DemoBean;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DemoBean demoBean = context.getBean(DemoBean.class);

		System.out.println("Result: " + demoBean.getResult()); // Output: 10
		System.out.println("Person Name: " + demoBean.getPersonName()); // Output: Makarand
	}
}