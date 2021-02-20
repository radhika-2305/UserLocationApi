package com.userLocation.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.userLocation.api.model.User;
import com.userLocation.api.repository.UserRepository;

@SpringBootApplication(scanBasePackages = { "com.userLocation.api.repository", "com.userLocation.api.service",
		"com.userLocation.api.controller,com.userLocation.api.model" })
@EntityScan(basePackageClasses = User.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class UserLocationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLocationApiApplication.class, args);
	}

}
