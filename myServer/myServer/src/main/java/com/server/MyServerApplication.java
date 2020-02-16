package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import controllers.VirtualMachineController;


@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "controllers"} )
public class MyServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyServerApplication.class, args);
	}
}
