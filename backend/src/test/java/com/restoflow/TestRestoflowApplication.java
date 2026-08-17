package com.restoflow;

import org.springframework.boot.SpringApplication;

public class TestRestoflowApplication {

	public static void main(String[] args) {
		SpringApplication.from(RestoflowApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
