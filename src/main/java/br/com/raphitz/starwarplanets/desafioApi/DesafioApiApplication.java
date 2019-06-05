package br.com.raphitz.starwarplanets.desafioApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableMongoRepositories(value = "br.com.raphitz.starwarplanets.repositorios", considerNestedRepositories = true)
@ComponentScan(basePackages = { "br.com.raphitz" })
@SpringBootApplication
@EnableAsync
public class DesafioApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(DesafioApiApplication.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}


}