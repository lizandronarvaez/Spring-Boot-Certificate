package com.springboot.interceptors.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class InterceptorsControllers {

    @GetMapping("submit")
    public Map<String, Object> submit() {
        return Collections.singletonMap("message","submit");
    }

    @GetMapping("submit2")
    public Map<String, Object> submit2() {
        return Collections.singletonMap("message", "submit2");
    }

    @GetMapping("submit3")
    public Map<String, Object> submit3() {
        return Collections.singletonMap("message", "submit3");
    }
}
