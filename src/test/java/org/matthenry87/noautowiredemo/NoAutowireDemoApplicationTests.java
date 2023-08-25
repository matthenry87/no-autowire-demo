package org.matthenry87.noautowiredemo;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.matthenry87.noautowiredemo.api.MyService;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RequiredArgsConstructor
class NoAutowireDemoApplicationTests {

	private final MyService myService;

	@Test
	void contextLoads() {

		assertThat(myService).isNotNull();
	}

}
