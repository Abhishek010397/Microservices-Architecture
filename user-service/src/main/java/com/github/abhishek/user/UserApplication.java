package com.github.abhishek.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	//Bean method cannot be private or final
	//Also when using Service Registry we have to make sure its Loadbalanced
	@Bean
	@LoadBalanced
	public  RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
