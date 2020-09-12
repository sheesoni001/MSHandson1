package com.ibm.currencyconversionfactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class CurrencyconversionfactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyconversionfactorApplication.class, args);
	}

}
