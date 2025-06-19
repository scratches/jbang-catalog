//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-dependencies:3.5.0@pom
//DEPS org.springframework.boot:spring-boot-starter
package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenericApplication {
	public static void main(String[] args) {
		SpringApplication.run(GenericApplication.class, args);
	}
}
