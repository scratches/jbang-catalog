//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-dependencies:3.5.0@pom
//DEPS org.springframework.boot:spring-boot-starter
package example;

import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScriptRun {

	public static SpringApplicationBuilder from(Class<?> ...classes) {
		Set<Class<?>> classList = new LinkedHashSet<>(List.of(classes));
		classList.add(ScriptRun.class);
		return new SpringApplicationBuilder(classList.toArray(new Class[0]));
	}

}
