package me.kolganov;

import me.kolganov.domain.Question;
import me.kolganov.service.QuestionService;
import me.kolganov.service.Tester;
import me.kolganov.service.TesterImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Locale;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        QuestionService questionService = context.getBean(QuestionService.class);

        List<Question> questions = questionService.getAll();

        Tester tester = context.getBean(Tester.class);
        tester.setLocale(Locale.ENGLISH);
        tester.startTesting(questions);
    }
}
