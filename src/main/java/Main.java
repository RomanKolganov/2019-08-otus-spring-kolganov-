import domain.Question;
import domain.ResourceLoader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;
import service.Questioner;
import service.Tester;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionService questionService = context.getBean(QuestionService.class);
        ResourceLoader resourceLoader = context.getBean(ResourceLoader.class);

        List<Question> questions = questionService.getAll(resourceLoader);

        Tester tester = new Tester();
        tester.startTesting(questions);
    }
}
