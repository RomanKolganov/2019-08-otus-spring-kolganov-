package me.kolganov.studentTestApplication.service;

import me.kolganov.studentTestApplication.domain.Question;
import me.kolganov.studentTestApplication.utils.Constants;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class IOServiceImpl implements IOService {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private LocalizationService messageSource;

    public IOServiceImpl(LocalizationService messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void writeMessage(String key) {
        System.out.println(messageSource.getMessage(key));
    }

    @Override
    public void writeMessage(String key, Object... s) {
        System.out.println(String.format(messageSource.getMessage(key), (Object[]) s));
    }

    @Override
    public void writeQuestion(Question question) {
        writeMessage(Constants.QUESTION);
        System.out.println(question.getText());
        System.out.println();
    }

    @Override
    public void writeAnswers(Question question) {
        writeMessage(Constants.ANSWER);
        System.out.println(question.getAnswer1());
        System.out.println(question.getAnswer2());
        System.out.println(question.getAnswer3());
        System.out.println(question.getAnswer4());
    }

    @Override
    public String askString() {
        String s = "";
        try {
            s = reader.readLine();
            while (!s.matches("[a-zA-Zа-яА-Я]+")) {
                writeMessage(Constants.LETTERS);
                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public String askNumber() {
        String s = "";

        try {
            s = reader.readLine();

            while (!s.matches("[1-4]")) {
                writeMessage(Constants.NUMBERS);
                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
