package com.springboot.aopprogramacionorientadaaspecto.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
@Order(2)
public class GreetingAspect {

    /**
     * Para que funcione los puntos de cortes hay que añadir la clase donde estan los puntos de cortes
     * y el metodo que va a ser llamado
     *              
     *          GreetingServicePointCuts.greetinLoggerPointCut()
     * 
     */

    // Antes de que se realize una accion
    @Before("GreetingServicePointCuts.greetinLoggerPointCut()")
    public void loggerBefore(JoinPoint jP) {

        String method = jP.getSignature().getName();
        String args = Arrays.toString(jP.getArgs());

        log.info("Antes: " + method + " con los argumentos " + args);
    }

    // Se ejecuta si no hay ningun error
    @AfterReturning("GreetingServicePointCuts.greetinLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint jP) {

        String method = jP.getSignature().getName();
        String args = Arrays.toString(jP.getArgs());

        log.info("Despues de ejecutar si no hay ningun error: " + method + " con los argumentos " + args);
    }

    // Se ejectuta solo si hubiese un error
    @AfterThrowing("GreetingServicePointCuts.greetinLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint jP) {
        String method = jP.getSignature().getName();
        String args = Arrays.toString(jP.getArgs());
        log.info("Despues de lanzar excepcion: " + method + " con los argumentos " + args);
    }

    // Despues de que se realize una accion si hubiese o no errores
    @After("GreetingServicePointCuts.greetinLoggerPointCut()")
    public void loggerAfter(JoinPoint jP) {

        String method = jP.getSignature().getName();
        String args = Arrays.toString(jP.getArgs());

        log.info("Despues: " + method + " con los argumentos " + args);

    }

    // Around
    @Around("GreetingServicePointCuts.greetinLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint pJp) throws Throwable {
        String method = pJp.getSignature().getName();
        String args = Arrays.toString(pJp.getArgs());
        Object result = null;
        try {
            log.info("Metodo: " + method + "() con los parametros " + args);
            result = pJp.proceed();
            log.info("El método: " + method + "() retorna el resultado: " + result);
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            log.error("Error en la llamada del metodo: " + method + "()");
            throw e;
        }
    }

}