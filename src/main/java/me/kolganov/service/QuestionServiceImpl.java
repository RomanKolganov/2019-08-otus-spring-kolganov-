package me.kolganov.service;

import me.kolganov.dao.QuestionDAO;
import me.kolganov.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    private final QuestionDAO dao;

    public QuestionServiceImpl(QuestionDAO dao) {
        this.dao = dao;
    }

    public List<Question> getByLocale() {
        return dao.findByLocale();
    }
}
