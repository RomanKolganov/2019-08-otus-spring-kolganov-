package service;

import dao.QuestionDAO;
import domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    private final QuestionDAO dao;

    @Autowired
    public QuestionServiceImpl(QuestionDAO dao) {
        this.dao = dao;
    }

    public List<Question> getAll() {
        return dao.findAll();
    }
}
