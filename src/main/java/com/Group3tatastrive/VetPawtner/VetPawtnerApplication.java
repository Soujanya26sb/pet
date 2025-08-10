package com.Group3tatastrive.VetPawtner;

import com.Group3tatastrive.VetPawtner.Entity.Dashboard;
import com.Group3tatastrive.VetPawtner.Entity.Order;
import com.Group3tatastrive.VetPawtner.Entity.Pet;
import com.Group3tatastrive.VetPawtner.Entity.User;
import com.Group3tatastrive.VetPawtner.Repository.DashboardRepository;
import com.Group3tatastrive.VetPawtner.Repository.OrderRepository;
import com.Group3tatastrive.VetPawtner.Repository.PetRepository;
import com.Group3tatastrive.VetPawtner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class VetPawtnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VetPawtnerApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	DashboardRepository dashboardRepository;
	@Autowired
	PetRepository petRepository;



	@Override
	public void run(String... args) throws Exception {
		String email = "darshi@example.com";
		User user; // declare before if
		if (!userRepository.existsByEmail(email)) {
			user = new User();
			user.setRole(User.Role.user);
			userRepository.save(user);
		} else {
			user = userRepository.findByEmail(email).orElseThrow(null);
		}

		Order order  = new Order();
		order.setOrderId(56487);
		order.setUser(order.getUser());
		order.setProduct(order.getProduct());
		order.setQuantity(35);
		order.setTotalPrice(1200.0);
		order.setOrderDate(LocalDate.of(2025,8,4));
		order.setStatus(order.getStatus());


		Dashboard dashboard = new Dashboard();
		dashboard.setUser(user);
		dashboard.setTotalPets(1);
		dashboard.setTotalOrders(0);
		dashboardRepository.save(dashboard);

		Pet pet = new Pet();
		pet.setUser(user);
		pet.setName("Tommy");
		pet.setBreed("Labrador");
		pet.setGender(Pet.Gender.male);
		pet.setDob(LocalDate.of(2025, 8, 10));
		pet.setVaccinationDetails("Rabies, Distemper");
		petRepository.save(pet);


	}

}
