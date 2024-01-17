package com.springboot.aopprogramacionorientadaaspecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Es opcional activa los aspectos
@EnableAspectJAutoProxy
@SpringBootApplication
public class AopProgramacionOrientadaAspectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopProgramacionOrientadaAspectoApplication.class, args);
	}

}
