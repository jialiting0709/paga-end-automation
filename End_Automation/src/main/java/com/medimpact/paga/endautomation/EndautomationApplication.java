package com.medimpact.paga.endautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;



@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class EndautomationApplication {
    public static void main(String[] args) {

        SpringApplication.run(EndautomationApplication.class,args);
    }

}
