package com.oracle.model;

import org.springframework.stereotype.Component;

@Component("person")
public class Person {
    private String name = "Makarand";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
