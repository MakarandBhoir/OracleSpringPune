package com.oracle.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoBean {

    @Value("#{2 * 5}")
    private int result;

    @Value("#{person.name}")
    private String personName;

    public int getResult() {
        return result;
    }

    public String getPersonName() {
        return personName;
    }
}