package com.eazybytes.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountsApplication {

	/**
	 * Entry point for the spring boot application. This method is invoked by the
	 * JVM when the program is started.
	 *
	 * @param args The command line arguments. These are passed to the application by
	 * the user.
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}