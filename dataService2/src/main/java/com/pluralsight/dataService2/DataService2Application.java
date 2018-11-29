package com.pluralsight.dataService2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;

@SpringBootApplication
@RestController
public class DataService2Application {


    private static Logger log = LoggerFactory.getLogger(DataService2Application.class);


    public static void main(String[] args) {
        SpringApplication.run(DataService2Application.class, args);
    }

    @Autowired

    @GetMapping("/hi")
    String hi() {
        log.info("Success");
        return "Hello";
    }

    @RequestMapping(value = "/customer/{cid}/vehicledetails", method = RequestMethod.GET)
    public @ResponseBody
    String getCustomerVehicleDetails(@PathVariable Integer cid) {

        String result;


        Hashtable<Integer, String> vehicles = new Hashtable<Integer, String>();
        vehicles.put(100, "Lincoln Continental; Plate SNUG30");
        vehicles.put(101, "Chevrolet Camaro; Plate R7TYR43");
        vehicles.put(102, "Volkswagen Beetle; Plate 6CVI3E2");

        result = vehicles.get(cid);
        log.info("Vehicles info: " + result);


        return result;
    }
}