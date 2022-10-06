package com.sportyshoes;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SportyshoesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApiApplication.class, args);
		System.out.println("Sporty Shoes Spring Boot App running");
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.sportyshoes"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Spring Boot Swagger Demo API",
				"Spring Boot demo application with Swagger",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Asheesh dixit", "https://github.com/Asheesh-Dixit/", "asheeshdixit6@gmail.com"),
				"API License",
				"https://github.com/Asheesh Dixit/",
				Collections.emptyList()
				);
	}

}
