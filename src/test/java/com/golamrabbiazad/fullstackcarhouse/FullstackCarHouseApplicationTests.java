package com.golamrabbiazad.fullstackcarhouse;

import com.golamrabbiazad.fullstackcarhouse.web.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FullstackCarHouseApplicationTests {

	@Autowired
	private CarController controller;

	@Test
	@DisplayName("Application Context Loads")
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	@DisplayName("simple test case")
	public void testMethod() {
		assertThat("Learn Spring Boot").startsWith("Learn");
	}
}
