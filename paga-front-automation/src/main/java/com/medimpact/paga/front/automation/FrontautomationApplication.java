package com.medimpact.paga.front.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class FrontautomationApplication {
	 public static void main(String[] args) {

	     SpringApplication.run(FrontautomationApplication.class,args);
	 }

}
