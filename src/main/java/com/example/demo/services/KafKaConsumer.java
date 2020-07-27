package com.example.demo.services;

import com.example.demo.model.Customer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {
    @KafkaListener(topics="${jsa.kafka.topic}")
    public void processMessage(Customer customer) {
        System.out.println("received content = " + customer);
    }
}
