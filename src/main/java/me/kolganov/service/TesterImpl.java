package me.kolganov.service;

import me.kolganov.domain.Question;
import me.kolganov.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterImpl implements Tester {
    private IOService ioService;

    public TesterImpl(IOService ioService) {
        this.ioService = ioService;
    }

    public void startTesting(List<Question> questions) {
        ioService.writeMessage(Constants.NAME);
        String name = ioService.askString();

        ioService.writeMessage(Constants.SURNAME);
        String surname = ioService.askString();

        ioService.writeMessage(Constants.GRATS, name, surname);
        ioService.writeMessage(Constants.START_TEST);

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
}
