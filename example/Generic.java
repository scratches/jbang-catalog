//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-dependencies:3.5.5@pom
//DEPS org.springframework.boot:spring-boot-starter

package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Used by SpringScript to launch a generic Spring Boot application
@SpringBootApplication public class Generic {
	public static void main(String[] args) {
		SpringApplication.run(Generic.class, args);
	}
}
