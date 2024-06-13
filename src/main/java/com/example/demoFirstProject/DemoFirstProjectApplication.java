package com.example.demoFirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoFirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFirstProjectApplication.class, args);

		//@Bean - to create a object in springboot application
		//@Controller , @service , @repository , @component , @restcontroller - at class level
		//@Bean -at method level
	}

}
