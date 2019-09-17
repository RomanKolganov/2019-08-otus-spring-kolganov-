package me.kolganov.studentTestApplication.service;

import me.kolganov.studentTestApplication.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getByLocale();
}
