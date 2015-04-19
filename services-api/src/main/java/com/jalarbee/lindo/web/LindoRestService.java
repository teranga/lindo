package com.jalarbee.lindo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Abdoulaye Diallo
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.jalarbee.lindo")
public class LindoRestService {

    public static void main(String[] args) {
        SpringApplication.run(new Object[] {LindoRestService.class}, args);
    }
}
