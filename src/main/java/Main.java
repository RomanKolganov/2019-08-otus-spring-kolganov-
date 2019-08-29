import domain.Answer;
import domain.Question;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AnswerService;
import service.QuestionService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionService questionService = context.getBean(QuestionService.class);
        AnswerService answerService = context.getBean(AnswerService.class);

        Question question = questionService.getById(1);
        List<Answer> answers = answerService.getById(1);

        System.out.println(question.getText());
        for (Answer a : answers) {
            System.out.println(a.getText());
        }
    }
}
