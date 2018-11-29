package com.pluralsight.dataService1;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Hashtable;
import java.util.Random;

@SpringBootApplication
@RestController
public class DataService1Application {


    public static void main(String[] args) {
        SpringApplication.run(DataService1Application.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(DataService1Application.class.getName());



    @RequestMapping(value = "/customer/{cid}/contactdetails", method = RequestMethod.GET)
    public @ResponseBody
    String getCustomerContactDetails(@PathVariable Integer cid) throws InterruptedException {

        //add arbitrary latency
        Random r = new Random();
        int multiplier = r.nextInt(5) * 1000;
        log.info("multiplier: " + multiplier);
        Thread.sleep(multiplier);


        Hashtable<Integer, String> customers = new Hashtable<Integer, String>();
        customers.put(100, "Beverly Goldberg");
        customers.put(101, "Dave Kim");
        customers.put(102, "Lainey Lewis");

        String result = customers.get(cid);
        log.info("Customer: " + result);
        return result;
    }
}