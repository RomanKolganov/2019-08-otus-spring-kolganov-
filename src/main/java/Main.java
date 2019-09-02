import domain.Question;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;
import service.Tester;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionService questionService = context.getBean(QuestionService.class);

        List<Question> questions = questionService.getAll();

        Tester tester = new Tester();
        tester.startTesting(questions);
    }
}
