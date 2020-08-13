package com.zero.fund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZeroFundApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ZeroFundApp.class);
        app.run(args);
    }

}