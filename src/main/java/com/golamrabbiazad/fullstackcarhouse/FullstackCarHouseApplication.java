package com.golamrabbiazad.fullstackcarhouse;

import com.golamrabbiazad.fullstackcarhouse.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class FullstackCarHouseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(FullstackCarHouseApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(FullstackCarHouseApplication.class, args);
		logger.info("Application Started!");
	}

	private final CarRepository repository;
	private final OwnerRepository ownerRepository;
	private final AppUserRepository userRepository;

	public FullstackCarHouseApplication(CarRepository repository, OwnerRepository ownerRepository, AppUserRepository userRepository) {
		this.repository = repository;
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
    }

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new AppUser("subscriber59", "$2a$12$IfcucP0Mzs6OyQ7xpLPe2urpJoxDVdUkVxH.ndtcsvoStqhVE7TiS", "ADMIN"));


		Owner owner1 = new Owner("Owner", "1");
		Owner owner2 = new Owner("Mr", "2");

		ownerRepository.saveAll(Arrays.asList(owner1, owner2));


		repository.save(
				new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59_0000, "I love it", owner1)
		);
		repository.save(
				new Car("Ford", "Cat", "Red", "HGF-1121", 2024, 100_0000, "I love the most", owner1)
		);
		repository.save(
				new Car("Toyota", "Prius", "Silver", "KKO-0212", 2023, 39000, "This is cool", owner2)
		);

		for (Car car : repository.findAll()) {
			logger.info("{} {}", car.getBrand(), car.getModel());
		}
	}
}
