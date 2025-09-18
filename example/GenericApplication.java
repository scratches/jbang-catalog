//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-dependencies:3.5.5@pom
//DEPS org.springframework.boot:spring-boot-starter

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication public class GenericApplication {
	public static void main(String[] args) {
		SpringApplication.run(GenericApplication.class, args);
	}
}
