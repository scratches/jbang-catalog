//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-dependencies:4.0.1@pom
//DEPS org.springframework.boot:spring-boot-starter
//SOURCES Generic.java

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ClassUtils;

public class SpringScript {

	public static SpringApplicationBuilder from(Class<?>... classes) {
		return new SpringApplicationBuilder(extract(classes, 2));
	}

	public static ConfigurableApplicationContext run(String... args) {
		return new SpringApplicationBuilder(extract(new Class[0], 2)).run(args);
	}

	private static Class<?>[] extract(Class<?>[] classes, int stackLevel) {
		Set<Class<?>> classList = new LinkedHashSet<>(List.of(classes));
		classList.add(example.Generic.class);
		Class<?> caller = ClassUtils.resolveClassName(new RuntimeException().getStackTrace()[stackLevel].getClassName(),
				null);
		if (caller != null) {
			for (Class<?> c : caller.getDeclaredClasses()) {
				classList.add(c);
			}
			classList.add(caller);
		}
		return classList.toArray(new Class[0]);
	}
}
