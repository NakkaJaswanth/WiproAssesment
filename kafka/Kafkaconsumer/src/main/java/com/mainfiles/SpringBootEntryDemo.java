package com.mainfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com.repository")
@EntityScan("com.entity")
public class SpringBootEntryDemo {
	public static void main(String[] args) {
	      SpringApplication.run(SpringBootEntryDemo.class, args);
 
	}
}
