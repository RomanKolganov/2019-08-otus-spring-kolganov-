import domain.Question;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;
import service.Tester;

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
