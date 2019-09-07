package me.kolganov;

import me.kolganov.domain.Question;
import me.kolganov.service.QuestionService;
import me.kolganov.service.Tester;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        QuestionService questionService = context.getBean(QuestionService.class);

        List<Question> questions = questionService.getAll();

        Tester tester = new Tester();
        tester.startTesting(questions);
    }
}
