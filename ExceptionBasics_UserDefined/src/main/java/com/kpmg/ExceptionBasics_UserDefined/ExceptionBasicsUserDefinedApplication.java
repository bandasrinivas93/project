package com.kpmg.ExceptionBasics_UserDefined;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;



@SpringBootApplication
@ComponentScan("com.kpmg")
@EntityScan("com.kpmg")
@EnableJpaRepositories("com.kpmg")
//@Profile("dev")
public class ExceptionBasicsUserDefinedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionBasicsUserDefinedApplication.class, args);
	}
	
	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	
	}

	
	public OpenAPI m1() {
		return new OpenAPI().info(new Info().title("hello vendor").description("crud operation").version("1.0"));
		
    

	    
	}

	
	 
}

