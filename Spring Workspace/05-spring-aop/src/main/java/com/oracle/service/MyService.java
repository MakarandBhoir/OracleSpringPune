package com.oracle.service;

import org.springframework.stereotype.Component;

@Component
public class MyService {

	public void doWork() {
		System.out.println("Doing some work inside MyService.doWork()");
	}
}
