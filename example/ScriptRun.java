//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-dependencies:3.5.0@pom
//DEPS org.springframework.boot:spring-boot-starter
//SOURCES GenericApplication.java

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.ClassUtils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ScriptRun {

	public static SpringApplicationBuilder from(Class<?> ...classes) {
		Set<Class<?>> classList = new LinkedHashSet<>(List.of(classes));
		classList.add(example.GenericApplication.class);
		Class<?> caller = ClassUtils.resolveClassName(new RuntimeException().getStackTrace()[1].getClassName(), null);
		if (caller != null) {
			for (Class<?> c : caller.getDeclaredClasses()) {
				classList.add(c);
			}
		}
		return new SpringApplicationBuilder(classList.toArray(new Class[0]));
	}

}
