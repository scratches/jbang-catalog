///usr/bin/env jbang "$0" "$@" ; exit $?
//SOURCES springbom@scratches
//SOURCES generic@scratches
//JAVA 17

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration class Demo {

	@Bean
	CommandLineRunner runner() {
		return args -> System.out.println("Hello, World!");
	}

}

new SpringApplication(GenericApplication.class, Demo.class).run(args);
