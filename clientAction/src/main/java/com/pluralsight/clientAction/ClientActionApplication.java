package com.pluralsight.clientAction;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ClientActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientActionApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    Sampler getSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

    @GetMapping("/hi")
    String hi() {
        return this.restTemplate().getForEntity("http://localhost:9081/hi", String.class).getBody();
    }

}
