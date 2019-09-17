package me.kolganov.studentTestApplication;

import me.kolganov.studentTestApplication.service.Runner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentTestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentTestApplication.class, args);

		Runner runner = context.getBean(Runner.class);
		runner.run();
	}
}
