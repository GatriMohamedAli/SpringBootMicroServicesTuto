package com.springmicro.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class CustomerConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
