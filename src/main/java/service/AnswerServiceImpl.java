package service;

import dao.AnswerDAO;
import domain.Answer;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    private AnswerDAO dao;

    public AnswerServiceImpl(AnswerDAO dao) {
        this.dao = dao;
    }

    public List<Answer> getById(int id) {
        return dao.findById(id);
    }
}
