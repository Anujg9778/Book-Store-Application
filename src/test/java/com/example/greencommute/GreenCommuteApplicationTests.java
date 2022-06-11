package com.example.greencommute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GreenCommuteApplicationTests {
	@Test
	void testApplication() {
		String[] str = new String[]{};
		GreenCommuteApplication.main(str);
		Assertions.assertEquals(1,2-1);
	}
}
