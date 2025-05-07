package com.example.productservicecapstone.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    //RestTemplate is used to call 3rd party api's. Read more about it.
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
