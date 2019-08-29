package service;

import domain.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getById(int id);
}
