package com.oracle;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	public String greet(String name) {
		if (name == null || name.isEmpty()) {
			return "Hello, World!";
		}
		return "Hello, " + name + "!";
	}
}
