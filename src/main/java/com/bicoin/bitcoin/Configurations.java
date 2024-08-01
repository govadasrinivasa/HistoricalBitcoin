package com.bicoin.bitcoin;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configurations {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) throws Exception {
		return builder.build();
	}
	
}
