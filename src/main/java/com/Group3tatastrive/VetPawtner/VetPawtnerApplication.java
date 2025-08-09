package com.Group3tatastrive.VetPawtner;

import com.Group3tatastrive.VetPawtner.Entity.User;
import com.Group3tatastrive.VetPawtner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VetPawtnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VetPawtnerApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;


	@Override
	public void run(String... args) throws Exception {
		String email = "darshi@example.com";
		if (!userRepository.existsByEmail(email)) {
			User user = new User();
			user.setUsername("Darshan");
			user.setEmail(email);
			user.setPassword("hashedPassword"); // Hash your password!
			user.setUserphone("3245678974");
			user.setUseraddress("India");
			user.setRole(User.Role.user);
			userRepository.save(user);
		} else {
			System.out.println("User with email " + email + " already exists. Skipping insert.");
		}
	}
}
