package com.pluralsight.customerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CustomerServiceApplication {

	private static Logger log = LoggerFactory.getLogger(CustomerServiceApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate webTemplate;

	@RequestMapping(value="/customer/{cid}", method= RequestMethod.GET)
	public @ResponseBody
	String getCustomer(@PathVariable Integer cid) {

		ResponseEntity<String> contact = webTemplate.getForEntity("http://localhost:9081/customer/"+cid+"/contactdetails", String.class);
		ResponseEntity<String> vehicle = webTemplate.getForEntity("http://localhost:9082/customer/"+cid+"/vehicledetails", String.class);

		log.info(contact.getBody() + " | " + vehicle.getBody());

		return contact.getBody() + " | " + vehicle.getBody();

	}
}
