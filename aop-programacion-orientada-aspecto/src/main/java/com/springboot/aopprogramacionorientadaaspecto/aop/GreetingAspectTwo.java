package com.springboot.aopprogramacionorientadaaspecto.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@Order(1)
public class GreetingAspectTwo {


    @Before("GreetingServicePointCuts.greetinLoggerPointCutTwo()")
    public void loggerBefore(JoinPoint jP) {

        String method = jP.getSignature().getName();
        String args = Arrays.toString(jP.getArgs());

        log.info("Antes: " + method + " invocado con los parametros " + args);
    }
}
