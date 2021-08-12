package com.guilherme1550.apiestacionamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiEstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEstacionamentoApplication.class, args);
	}
}
