package service;

import domain.Question;
import domain.ResourceLoader;

import java.util.List;

public interface QuestionService {
    List<Question> getAll(ResourceLoader resourceLoader);
}
