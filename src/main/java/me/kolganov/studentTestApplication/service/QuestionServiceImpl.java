package me.kolganov.studentTestApplication.service;

import me.kolganov.studentTestApplication.dao.QuestionDAO;
import me.kolganov.studentTestApplication.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    private final QuestionDAO dao;

    public QuestionServiceImpl(QuestionDAO dao) {
        this.dao = dao;
    }

    public List<Question> getAll() {
        return dao.findAll();
    }
}
