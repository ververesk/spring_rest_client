package com.grigorovich.spring.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.grigorovich.spring.rest")
public class MyConfig {

    @Bean //используется для http request
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
