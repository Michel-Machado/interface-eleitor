package com.grupo04pj01.urna.interfaceeleitor.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Configuration
    public class Configuracao {

        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
}
