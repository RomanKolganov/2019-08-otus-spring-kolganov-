import domain.Question;
import domain.ResourceLoader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionService questionService = context.getBean(QuestionService.class);
        ResourceLoader resourceLoader = context.getBean(ResourceLoader.class);

        List<Question> questions = questionService.getAll(resourceLoader);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name;
        String surname;

        System.out.println("Введите свое имя:");
        name = reader.readLine();
        System.out.println("Введите свою фамилию:");
        surname = reader.readLine();
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
            String answer = reader.readLine();

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
