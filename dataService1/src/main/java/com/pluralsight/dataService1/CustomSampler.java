package com.pluralsight.dataService1;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomSampler {
    @Bean
    public Sampler smartSampler(){
        return  new Sampler() {
            @Override
            public boolean isSampled(long l) {
                System.out.println("Custom sampler used!!!");
                return false;
            }
        };
    }
}
