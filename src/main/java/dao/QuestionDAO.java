package dao;

import domain.Question;
import domain.ResourceLoader;

import java.util.List;

public interface QuestionDAO {
    List<Question> findAll(ResourceLoader resourceLoader);
}
