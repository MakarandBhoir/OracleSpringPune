package com.oracle.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.oracle.service.MyService.doWork(..))")
    public void beforeAdvice() {
        System.out.println("[Before] MyService.doWork() is about to be called");
    }

    @After("execution(* com.oracle.service.MyService.doWork(..))")
    public void afterAdvice() {
        System.out.println("[After] MyService.doWork() has been called");
    }
}