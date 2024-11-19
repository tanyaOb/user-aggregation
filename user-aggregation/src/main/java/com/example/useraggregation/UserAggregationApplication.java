package com.example.useraggregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UserAggregationApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAggregationApplication.class, args);
    }

}
