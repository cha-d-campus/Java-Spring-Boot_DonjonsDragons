package com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DonjonsAndDragonsRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonjonsAndDragonsRestAppApplication.class, args);
		System.out.println("Hello World !");
	}

}
