import domain.Question;
import domain.ResourceLoader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionService questionService = context.getBean(QuestionService.class);
        ResourceLoader resourceLoader = context.getBean(ResourceLoader.class);

        List<Question> questions = questionService.getAll(resourceLoader);

        for (Question q : questions) {
            System.out.println(q.getText());
            System.out.println(q.getAnswer1());
            System.out.println(q.getAnswer2());
            System.out.println(q.getAnswer3());
            System.out.println(q.getAnswer4());
        }
    }
}
