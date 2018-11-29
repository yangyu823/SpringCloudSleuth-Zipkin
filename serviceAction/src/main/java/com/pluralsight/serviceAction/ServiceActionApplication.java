package com.pluralsight.serviceAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceActionApplication {


    private static Logger log = LoggerFactory.getLogger(ServiceActionApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServiceActionApplication.class, args);
    }

    @GetMapping("/hi")
    String hi() {
        log.info("Success");
        return "Hello";
    }


}
