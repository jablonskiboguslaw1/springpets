package com.sda.javagda34.pets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PetsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PetsApplication.class, args);
    }


}
