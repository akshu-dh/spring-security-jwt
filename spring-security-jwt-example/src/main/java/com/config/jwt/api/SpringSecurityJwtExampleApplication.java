package com.config.jwt.api;

import com.config.jwt.api.entity.User;
import com.config.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUser(){
		List<User> users= Stream.of(
				new User(101, "admin", "password", "admin@gmail.com"),
				new User(102, "user1", "pwd1", "user1@gmail.com"),
				new User(103, "user2", "pwd2", "user2@gmail.com"),
				new User(104, "user3", "pwd3", "user3@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
