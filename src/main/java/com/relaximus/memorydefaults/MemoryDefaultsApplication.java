package com.relaximus.memorydefaults;

import com.martensigwart.fakeload.FakeLoadExecutor;
import com.martensigwart.fakeload.FakeLoadExecutors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MemoryDefaultsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoryDefaultsApplication.class, args);
	}

	@Bean
	FakeLoadExecutor fakeLoadExecutor() {
		return FakeLoadExecutors.newDefaultExecutor();
	}

}
