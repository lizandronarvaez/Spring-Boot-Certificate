package com.springboot.aopprogramacionorientadaaspecto.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingServiceImpl implements IGreetingService {

    @Override
    public String sayHello(String person, String phrase) {

        String greeting = phrase + " " + person;
        log.info(greeting);
        return greeting;
    }

    @Override
    public String sayHelloError(String person, String phrase) {
       
        throw new RuntimeException("Algún error");
    }

}
