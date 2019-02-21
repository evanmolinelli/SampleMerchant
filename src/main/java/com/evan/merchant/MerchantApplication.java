package com.evan.merchant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.evan.merchant.*"})
public class MerchantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantApplication.class, args);
	}

}
