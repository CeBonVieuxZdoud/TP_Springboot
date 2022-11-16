package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TWICClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(TWICClientApplication.class, args);
        System.out.println("Application Start");
    }

}
