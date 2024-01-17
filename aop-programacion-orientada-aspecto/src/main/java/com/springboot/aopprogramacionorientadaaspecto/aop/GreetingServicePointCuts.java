package com.springboot.aopprogramacionorientadaaspecto.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCuts {

    // Los puntos de cortes es mejor aplicar un singlenton de responsabilidad unica

    @Pointcut("execution(* com.springboot.aopprogramacionorientadaaspecto.services.*.*(..))")
    public void greetinLoggerPointCut() {
    }

    @Pointcut("execution(* com.springboot.aopprogramacionorientadaaspecto.services.*.*(..))")
    public void greetinLoggerPointCutTwo() {
    }
}
