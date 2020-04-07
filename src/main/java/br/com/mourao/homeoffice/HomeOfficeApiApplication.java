package br.com.mourao.homeoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class HomeOfficeApiApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HomeOfficeApiApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(HomeOfficeApiApplication.class, args);
	}
	
	@Bean
    public ObjectMapper buildObjectMapper() {
       return new ObjectMapper().setSerializationInclusion(Include.NON_NULL);
    }

}
