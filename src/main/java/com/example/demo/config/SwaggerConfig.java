package com.example.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * http://localhost:8080/swagger-ui/ --> HTML
 * http://localhost:8080/v2/api-docs -- JSON
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket swaggerConfiguration() {
		
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .build().apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {

		return new ApiInfo(
				"Proyecto Final Spring", 
				"Proyecto Final Spring de Mario Rico", 
				"1.0", 
				"http://localhost:8080/api/...", 
				new Contact("MarioRico","http://localhost:8080/api/termsOfServiceUrl","fullstack@mariorico.es"),
				"MarioRico",
				"https://www.mariorico.es",
				 Collections.emptyList());
	}
}