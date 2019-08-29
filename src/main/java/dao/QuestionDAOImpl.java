package dao;

import domain.Question;

public class QuestionDAOImpl implements QuestionDAO {
    public Question finById(int id) {
        return new Question(1, "Вопрос 1");
    }
}
