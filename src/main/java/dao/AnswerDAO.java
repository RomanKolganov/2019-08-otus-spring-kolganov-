package dao;

import domain.Answer;

import java.util.List;

public interface AnswerDAO {
    List<Answer> findById(int id);
}
