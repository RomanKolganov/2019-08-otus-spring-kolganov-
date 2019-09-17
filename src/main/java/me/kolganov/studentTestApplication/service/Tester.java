package me.kolganov.studentTestApplication.service;

import me.kolganov.studentTestApplication.domain.Question;

import java.util.List;

public interface Tester {
    void startTesting(List<Question> questions);
}
