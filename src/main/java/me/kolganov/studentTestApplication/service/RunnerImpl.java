package me.kolganov.studentTestApplication.service;

import me.kolganov.studentTestApplication.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerImpl implements Runner {
    private QuestionService questionService;
    private Tester tester;

    public RunnerImpl(QuestionService questionService, Tester tester) {
        this.questionService = questionService;
        this.tester = tester;
    }

    public void run() {
        List<Question> questions = questionService.getByLocale();// "ru" или "en"
        tester.startTesting(questions);
    }
}
