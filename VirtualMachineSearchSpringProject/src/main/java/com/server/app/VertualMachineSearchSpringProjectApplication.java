package com.server.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
@EnableAutoConfiguration
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})

public class VertualMachineSearchSpringProjectApplication {
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(VertualMachineSearchSpringProjectApplication.class, args);
	}

}
