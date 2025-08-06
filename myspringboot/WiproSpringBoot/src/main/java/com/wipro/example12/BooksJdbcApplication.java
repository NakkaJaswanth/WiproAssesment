package com.wipro.example12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.wipro.example12.repository")
public class BooksJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(BooksJdbcApplication.class, args);
    }
}
