package com.service.creditcardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.service" })
@EntityScan(basePackages = { "com.service" })
@EnableJpaRepositories(basePackages = { "com.service" })
public class CreditcardserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditcardserviceApplication.class, args);
    }

}
