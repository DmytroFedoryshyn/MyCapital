package ua.fedoryshyn.MyCapital;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class MyCapitalApplicationTests {

	@Test
	void contextLoads() {
		// Если тест стал зеленым — проблема была в том, что Spring не читал ваш application.properties
	}

}