package service;

import dao.QuestionDAO;
import domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    private QuestionDAO dao;

    public QuestionServiceImpl(QuestionDAO dao) {
        this.dao = dao;
    }

    public List<Question> getAll() {
        return dao.findAll();
    }
}
