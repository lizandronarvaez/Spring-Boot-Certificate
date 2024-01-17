package com.springboot.horario_clientes.interceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HourInterceptors implements HandlerInterceptor {

    @Value("${config.hour.open}")
    private Integer open;
    @Value("${config.hour.close}")
    private Integer close;

    // Antes de acceder o realizar una accion
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
        if (hour >= this.open && hour < this.close) {
            StringBuilder message = new StringBuilder();
            message.append("Bienvenidos al horario de atención al cliente")
                    .append(",")
                    .append(" antendemos desde las ")
                    .append(this.open)
                    .append(" hrs ")
                    .append(" hasta ")
                    .append(this.close)
                    .append(" hrs.")
                    .append("\nGracias por su visita");
            request.setAttribute("message", message.toString());

            return true;
        }
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();
        StringBuilder message = new StringBuilder();
        message.append("Cerrado, fuera del horario de atención al cliente")
                .append(" ")
                .append("Nuestro horario es de: ")
                .append(this.open)
                .append(" hrs ")
                .append(" hasta ")
                .append(this.close);

        data.put("message", message.toString());
        data.put("date", new Date());

        response.setContentType("application/json");
        response.setStatus(401);
        response.getWriter().write(mapper.writeValueAsString(message));
        return false;
    }

    // Despues de acceder o realizar una accion
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

}
