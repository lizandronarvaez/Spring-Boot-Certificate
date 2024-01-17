package com.form.app.springbootform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.form.app.springbootform.interceptors.CurrentTImeInterceptors;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private CurrentTImeInterceptors currentTImeInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(currentTImeInterceptors);
    }

}
