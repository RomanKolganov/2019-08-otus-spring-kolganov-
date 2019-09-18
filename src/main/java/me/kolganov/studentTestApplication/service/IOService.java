package me.kolganov.studentTestApplication.service;

import me.kolganov.studentTestApplication.domain.Question;

public interface IOService {
    void writeMessage(String key);
    void writeMessage(String key, Object... s);
    void writeQuestion(Question question);
    void writeAnswers(Question question);

    String askString();
    String askNumber();
    String getLocalizedString(String key);
}
