package com.form.app.springbootform.interceptors;

import java.util.Random;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CurrentTImeInterceptors implements HandlerInterceptor {

    final static Logger logger = org.slf4j.LoggerFactory.getLogger(CurrentTImeInterceptors.class);

    // Antes de que el controlador se ejecute
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;

            logger.info("Es un método del controlador: " + method.getMethod().getName());
        }

        logger.info("Tiempo transcurrido Interceptor: preHandle():Entrando...");
        logger.info("Interceptando handler: " + handler);

        long timeInit = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", timeInit);

        Random random = new Random();
        Integer timeTotal = random.nextInt(500);

        Thread.sleep(timeTotal);

        return true;
    }

    // Despues de se el controlador se ejecute
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

        long timeFinal = System.currentTimeMillis();
        long timeInit = (long) request.getAttribute("tiempoInicio");

        long currentTimeTotal = timeFinal - timeInit;

        if (handler instanceof HandlerMethod && modelAndView != null) {
            modelAndView.addObject("currentTimeTotal", currentTimeTotal);
        }

        logger.info("Tiempo transcurrido: " + currentTimeTotal + " milisegundos");
        logger.info("Tiempo transcurrido Interceptor: postHandle():Saliendo...");
    }

}
