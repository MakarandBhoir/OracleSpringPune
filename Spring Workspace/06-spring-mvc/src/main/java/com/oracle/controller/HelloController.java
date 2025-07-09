package com.oracle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC without Spring Boot!");
        return "hello";  // resolves to /WEB-INF/views/hello.jsp
    }
}