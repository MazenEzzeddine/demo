package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Customer;
import com.example.demo.services.KafkaProducer;
import com.example.util.Simple;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Autowired
	KafkaProducer producer;

	@Override
	public void run(String... arg0) throws Exception {
		// Send Mary customer

		Simple s = new Simple();
		s.saySomething();

		Customer mary = new Customer("Mary", 31);
		producer.send(mary);

		// Send Peter customer
		Customer peter = new Customer("Peter", 24);
		producer.send(peter);
	}
}
