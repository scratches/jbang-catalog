//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-dependencies:4.0.1@pom
//DEPS org.springframework.boot:spring-boot-starter

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Use this one in a .jsh because it has no package
@SpringBootApplication public class GenericApplication {
	public static void main(String[] args) {
		SpringApplication.run(GenericApplication.class, args);
	}
}
