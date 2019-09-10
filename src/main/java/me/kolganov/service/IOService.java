package me.kolganov.service;

import me.kolganov.domain.Question;

public interface IOService {
    void writeMessage(String key);
    void writeMessage(String key, Object... s);
    void writeQuestion(Question question);
    void writeAnswers(Question question);

    String askString();
    String askNumber();
}
