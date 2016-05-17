package net.lermex.inaction.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // advice will be work before invoking methods
    @Before("execution(* net.lermex.inaction.model.entity.*.*(..))")
    public void log(JoinPoint joinPoint){
        System.out.println(" INFO: " + joinPoint.getSignature().getName());
    }

}
