package me.kolganov.service;

import me.kolganov.domain.Question;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

@Service
public class TesterImpl implements Tester {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private MessageSource messageSource;
    private Locale locale;

    public TesterImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void startTesting(List<Question> questions) {
        writeMessage("name");
        String name = askString();

        writeMessage("surname");
        String surname = askString();

        writeMessage("grats", name, surname);
        writeMessage("startTest");

        int counter = 0;
        for (Question q : questions) {
            writeQuestion(q);
            writeAnswers(q);

            String answer = askNumber();

            if (answer.equals(q.getCorrectAnswer())) {
                writeMessage("correct");
                counter++;
            } else {
                writeMessage("notCorrect");
            }
        }
        writeMessage("result", counter, questions.size());
    }

    private String askString() {
        String s = "";
        try {
            s = reader.readLine();
            while (!s.matches("[a-zA-Zа-яА-Я]+")) {
                writeMessage("letters");
                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    private String askNumber() {
        String s = "";

        try {
            s = reader.readLine();

            while (!s.matches("[1-4]")) {
                writeMessage("numbers");
                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    private void writeMessage(String key) {
        System.out.println(messageSource.getMessage(key, null, locale));
    }

    private void writeMessage(String key, Object... s) {
        System.out.println(String.format(messageSource.getMessage(key, null, locale), (Object[]) s));
    }

    private void writeQuestion(Question question) {
        writeMessage("question");
        System.out.println(question.getText());
        System.out.println();
    }

    private void writeAnswers(Question question) {
        writeMessage("answer");
        System.out.println(question.getAnswer1());
        System.out.println(question.getAnswer2());
        System.out.println(question.getAnswer3());
        System.out.println(question.getAnswer4());
    }
}
