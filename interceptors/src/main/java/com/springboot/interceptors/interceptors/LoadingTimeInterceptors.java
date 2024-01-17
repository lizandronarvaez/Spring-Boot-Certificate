package com.springboot.interceptors.interceptors;

import java.util.*;
import org.slf4j.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.*;

// import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.*;

@Component
public class LoadingTimeInterceptors implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptors.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String mHandlerMethod = ((HandlerMethod) handler).getMethod().getName();
        logger.info("LoadingTimeInterceptors:Entrando con @Prehandle: Método => " + mHandlerMethod);
        Long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);
        return true;

        // Personalizar una respuesta si un interceptor no cumple
        // Map<String, Object> json = new HashMap<>();
        // json.put("error", "No tienes acceso a este recurso");
        // ObjectMapper objectMapper = new ObjectMapper();
        // String jsonString = objectMapper.writeValueAsString(json);
        // response.setContentType("application/json");
        // response.setStatus(404);
        // response.getWriter().write(jsonString);
        //fin respuesta interceptor

        // return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        Long end = System.currentTimeMillis();
        Long start = (Long) request.getAttribute("start");
        Long result = end - start;
        logger.info("LoadingTimeInterceptors: Saliendo con @PostHandle");
        logger.info("Tiempo transcurrido: " + result + " segundos...");
    }

}
