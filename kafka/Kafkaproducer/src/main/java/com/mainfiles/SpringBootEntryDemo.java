package com.mainfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
  
@SpringBootApplication(scanBasePackages = "com")
public class SpringBootEntryDemo {
	public static void main(String[] args) {
	      SpringApplication.run(SpringBootEntryDemo.class, args);
 
	}
}
