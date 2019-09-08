package me.kolganov.service;

import me.kolganov.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getByLocale(String locale);
}
