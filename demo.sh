///usr/bin/env jbang "$0" "$@" ; exit $?
//SOURCES script@scratches
//DEPS https://github.com/scratches/spring-script
//JAVA 25

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Demo {

	@Bean
	CommandLineRunner runner() {
		return args -> System.out.println("Hello, World!");
	}

}

void main(String[] args) {
	SpringScript.run(args);
}
