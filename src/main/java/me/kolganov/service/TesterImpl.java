package me.kolganov.service;

import me.kolganov.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class TesterImpl implements Tester {
    private MessageSource messageSource;
    private Locale locale;

    public TesterImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void startTesting(List<Question> questions) {
        Questioner questioner = new Questioner();

        System.out.println(messageSource.getMessage("name", null, locale));
        String name = questioner.askString();
        System.out.println(messageSource.getMessage("surname", null, locale));
        String surname = questioner.askString();
        System.out.println(String.format(messageSource.getMessage("grats", null, locale), name, surname));
        System.out.println(messageSource.getMessage("startTest", null, locale));
        System.out.println();

        int counter = 0;
        for (Question q : questions) {
            System.out.println(messageSource.getMessage("question", null, locale));
            System.out.println(q.getText());
            System.out.println();
            System.out.println(messageSource.getMessage("answer", null, locale));
            System.out.println(q.getAnswer1());
            System.out.println(q.getAnswer2());
            System.out.println(q.getAnswer3());
            System.out.println(q.getAnswer4());
            String answer = questioner.askNumber();

            if (answer.equals(q.getCorrectAnswer())) {
                System.out.println(messageSource.getMessage("correct", null, locale));
                System.out.println();
                counter++;
            } else {
                System.out.println(messageSource.getMessage("notCorrect", null, locale));
                System.out.println();
            }
        }
        System.out.println(String.format(messageSource.getMessage("result", null, locale), counter, questions.size()));
    }
}
