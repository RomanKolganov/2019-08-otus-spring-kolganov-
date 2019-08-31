import domain.Question;
import domain.ResourceLoader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;
import service.Questioner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionService questionService = context.getBean(QuestionService.class);
        ResourceLoader resourceLoader = context.getBean(ResourceLoader.class);

        List<Question> questions = questionService.getAll(resourceLoader);
        Questioner questioner = new Questioner();

        String name;
        String surname;

        System.out.println("Введите свое имя:");
        name = questioner.askString();
        System.out.println("Введите свою фамилию:");
        surname = questioner.askString();
        System.out.println(String.format("Поздравляю, %s %s, ты справился.", name, surname));
        System.out.println("Теперь проходи тест на знание фильма Джей и молчаливый боб наносят ответный удар");
        System.out.println();

        int counter = 0;
        for (Question q : questions) {
            System.out.println("Вопрос: ");
            System.out.println(q.getText());
            System.out.println();
            System.out.println("Варианты ответов: ");
            System.out.println(q.getAnswer1());
            System.out.println(q.getAnswer2());
            System.out.println(q.getAnswer3());
            System.out.println(q.getAnswer4());
            String answer = questioner.askNumber();

            if (answer.equals(q.getCorrectAnswer())) {
                System.out.println("Да, правильно!");
                System.out.println();
                counter++;
            } else {
                System.out.println("Ну не...");
                System.out.println();
            }
        }
        System.out.println("Ваш результат: " + counter + "/8");
    }
}
