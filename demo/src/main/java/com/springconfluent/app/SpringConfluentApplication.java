package com.springconfluent.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springconfluent"})
@EnableBinding(Processor.class)
public class SpringConfluentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfluentApplication.class, args);
	}

}
