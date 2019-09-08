package me.kolganov.dao;

import me.kolganov.domain.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> findByLocale(String locale);
}
