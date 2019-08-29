package dao;

import domain.Answer;

import java.util.ArrayList;
import java.util.List;

public class AnswerDAOImpl implements AnswerDAO {
    public List<Answer> findById(int id) {
        List<Answer> answers = new ArrayList<Answer>();

        Answer answer1 = new Answer(1, "Ответ 1", 1);
        Answer answer2 = new Answer(2, "Ответ 2", 1);
        Answer answer3 = new Answer(3, "Ответ 3", 1);
        Answer answer4 = new Answer(4, "Ответ 4", 1);

        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);

        return answers;
    }
}
