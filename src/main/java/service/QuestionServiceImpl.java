package service;

import dao.QuestionDAO;
import domain.Question;

public class QuestionServiceImpl implements QuestionService{
    private QuestionDAO dao;

    public QuestionServiceImpl(QuestionDAO dao) {
        this.dao = dao;
    }

    public Question getById(int id) {
        return dao.finById(id);
    }
}
