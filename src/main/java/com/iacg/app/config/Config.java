package com.iacg.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class Config {

	@Bean
	Faker faker() {
		return new Faker();
	}
	
}
