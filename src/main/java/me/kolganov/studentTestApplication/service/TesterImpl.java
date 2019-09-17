package me.kolganov.studentTestApplication.service;

import me.kolganov.studentTestApplication.domain.Question;
import me.kolganov.studentTestApplication.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterImpl implements Tester {
    private IOService ioService;
    private QuestionService questionService;

    public TesterImpl(IOService ioService, QuestionService questionService) {
        this.ioService = ioService;
        this.questionService = questionService;
    }

    public boolean auth() {
        ioService.writeMessage(Constants.NAME);
        String name = ioService.askString();

        ioService.writeMessage(Constants.SURNAME);
        String surname = ioService.askString();

        ioService.writeMessage(Constants.GRATS, name, surname);
        ioService.writeMessage(Constants.START_TEST);

        return name != null || surname != null;
    }

    public void startTesting() {
        List<Question> questions = questionService.getAll();

        int counter = 0;
        for (Question q : questions) {
            ioService.writeQuestion(q);
            ioService.writeAnswers(q);

            String answer = ioService.askNumber();

            if (answer.equals(q.getCorrectAnswer())) {
                ioService.writeMessage(Constants.CORRECT);
                counter++;
            } else {
                ioService.writeMessage(Constants.NOT_CORRECT);
            }
        }
        ioService.writeMessage(Constants.RESULT, counter, questions.size());
    }

    @Override
    public String notAuth() {
        return ioService.getLocalizedString(Constants.AUTH);
    }
}
