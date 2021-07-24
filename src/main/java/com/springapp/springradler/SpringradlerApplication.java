package com.springapp.springradler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springapp.springradler/build/classes/java/main/com/springapp/springradler/service/mapper")
public class SpringradlerApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringradlerApplication.class, args);
	}

}

/**
 * -- To run application locally docker-compose up --build postgres redis app
 * 
 * -- Use Redis CLI docker exec -it sbs_redis /bin/bash redis-cli
 * 
 * -- Swagger doc http://localhost:8080/v2/api-docs
 * 
 * -- Swagger UI http://localhost:8080/swagger-ui/
 */