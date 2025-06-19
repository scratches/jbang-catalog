//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-dependencies:3.5.0@pom
//DEPS org.springframework.boot:spring-boot-starter
//SOURCES GenericApplication.java

import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ScriptRun {

	public static SpringApplicationBuilder from(Class<?> ...classes) {
		Set<Class<?>> classList = new LinkedHashSet<>(List.of(classes));
		classList.add(example.GenericApplication.class);
		return new SpringApplicationBuilder(classList.toArray(new Class[0]));
	}

}
