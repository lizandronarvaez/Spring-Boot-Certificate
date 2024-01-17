package com.springboot.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private HandlerInterceptor loadingTimeInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry
                // Agregar interceptor
                .addInterceptor(loadingTimeInterceptors)

                // Se pasa por aprametro la ruta que solamente queremos que se eejecte
                // .addPathPatterns("/app/submit", "/app/submit2");

                // Se excluyen las rutas que solamente queremos que se ejecuten los
                // interceptores
                // .excludePathPatterns("/app/submit");

                // O para todas la rutas
                .addPathPatterns("/app/**");
    }

}
