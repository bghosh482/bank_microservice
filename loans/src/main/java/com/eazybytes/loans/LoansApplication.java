package com.eazybytes.loans;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class LoansApplication {

    /**
     * Main entry point for the Spring Boot application.
     *
     * @param args Arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
