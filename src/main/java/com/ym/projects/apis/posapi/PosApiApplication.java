package com.ym.projects.apis.posapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class PosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApiApplication.class, args);
	}

}
