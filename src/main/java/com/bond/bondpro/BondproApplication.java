package com.bond.bondpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class BondproApplication {

    public static void main(String[] args) {
        SpringApplication.run(BondproApplication.class, args);
        System.out.println("OK");
    }

}
