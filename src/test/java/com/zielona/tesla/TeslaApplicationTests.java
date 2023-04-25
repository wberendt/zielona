package com.zielona.tesla;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TeslaApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertTrue(true);
	}

}
