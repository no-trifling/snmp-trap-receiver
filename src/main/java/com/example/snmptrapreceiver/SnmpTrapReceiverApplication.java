package com.example.snmptrapreceiver;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@SpringBootApplication
public class SnmpTrapReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnmpTrapReceiverApplication.class, args);
    }

}
