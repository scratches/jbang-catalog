You can run this script

```
$ jbang demo.md

WARNING: Using incubator modules: jdk.incubator.foreign, jdk.incubator.vector

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.0)

2025-09-18T08:50:56.687+01:00  INFO 1655917 --- [       Thread-3] o.s.boot.SpringApplication               : Starting application using Java 17.0.14 with PID 1655917 (started by dsyer in /home/dsyer/dev/scratch/jbang-catalog)
2025-09-18T08:50:56.689+01:00  INFO 1655917 --- [       Thread-3] o.s.boot.SpringApplication               : The following 1 profile is active: "git"
2025-09-18T08:50:57.075+01:00  INFO 1655917 --- [       Thread-3] o.s.boot.SpringApplication               : Started application in 0.758 seconds (process running for 2.547)
Hello, World!
```

To run a Markdown script with JBang you just need a bunch of Java language fragments in comments. You can include dependencies using the `//DEPS` directive, and you can use the `//SOURCES` directive to include other fragments. Each comment is a "snippet" in JShell terms.

You have to define the fragments in dependency order, i.e. the first fragment should not depend on any later fragments. That means the ugly set up has to be at the top of the file.

This is a utility to load a bunch of useful BOMs (Spring Boot, Cloud, etc.)

```java
//SOURCES springbom@scratches
```

This and includes the `spring-script` utility that has some useful things in it.
```java
//SOURCES generic@scratches
```

This is unnecessary but it shows how to include other Spring Boot starters:

```java
//DEPS org.springframework.boot:spring-boot-starter
```

We can ask for a specific version of Java as well:

```java
//JAVA 17
```

And some imports that we will need later:

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
```

You can define classes in the fragments, and they will be compiled and executed in the order they are defined.

```java
class HelloWorld {
	String name;
}
```

Watch out for type-level annotations: you have to include them on the same line as the class declaration, otherwise they will not be recognized.

```java
@Configuration class Demo {

	@Bean
	CommandLineRunner runner() {
		return args -> System.out.println("Hello, World!");
	}

}
```

The `SpringScript` utility defined in `scratches/spring-script` is in the default package and JShell doesn't like that, so you have to use `SpringApplication` directly to run Spring Boot. `GenericApplication` is a class that is used to run the application in a generic way, without needing to specify a main class (it's just an empty class with `@SpringBootApplication` on it).

```java
new SpringApplication(GenericApplication.class, Demo.class).run(args);
```

