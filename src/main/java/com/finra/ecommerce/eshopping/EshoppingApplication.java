package com.finra.ecommerce.eshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * @author Poornima
 */
@SpringBootApplication
@ComponentScan({"com.finra.ecommerce.eshopping"})
public class EshoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshoppingApplication.class, args);
	}
}
