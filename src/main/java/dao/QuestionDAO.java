package dao;

import domain.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> findAll();
}
