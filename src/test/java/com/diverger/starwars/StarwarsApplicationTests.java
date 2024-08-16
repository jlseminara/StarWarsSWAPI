package com.diverger.starwars;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest(classes = StarwarsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StarwarsApplicationTests {
	@Test
	void contextLoads() {
	}
}
