//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-dependencies:3.5.0@pom
//DEPS org.springframework.boot:spring-boot-starter
//SOURCES GenericApplication.java

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ClassUtils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SpringScript {

	public static SpringApplicationBuilder from(Class<?> ...classes) {
		return new SpringApplicationBuilder(extract(classes, 1));
	}

	public static ConfigurableApplicationContext run(String ...args) {
		return from(extract(new Class[0], 2)).run(args);
	}

	private static Class<?>[] extract(Class<?>[] classes, int stackLevel) {
		Set<Class<?>> classList = new LinkedHashSet<>(List.of(classes));
		classList.add(example.GenericApplication.class);
		Class<?> caller = ClassUtils.resolveClassName(new RuntimeException().getStackTrace()[stackLevel].getClassName(), null);
		if (caller != null) {
			for (Class<?> c : caller.getDeclaredClasses()) {
				classList.add(c);
			}
		}
		return classList.toArray(new Class[0]);
	}

}
