package com.ibm.urekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UrekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrekaserverApplication.class, args);
	}

}
