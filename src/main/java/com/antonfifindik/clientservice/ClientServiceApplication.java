package com.antonfifindik.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ClientServiceApplication {

/**
 * Entry point of the application.
 *
 * @param args start arguments
 */
public static void main(String[] args) {
SpringApplication.run(ClientServiceApplication.class, args);
}

}
