package me.kolganov.service;

import me.kolganov.domain.Question;

import java.util.List;

public interface Tester {
    void startTesting(List<Question> questions);
}
