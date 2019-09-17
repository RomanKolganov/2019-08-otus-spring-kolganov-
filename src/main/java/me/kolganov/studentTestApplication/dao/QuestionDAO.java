package me.kolganov.studentTestApplication.dao;

import me.kolganov.studentTestApplication.domain.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> findAll();
}
