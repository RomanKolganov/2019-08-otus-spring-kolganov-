package me.kolganov.service;

import me.kolganov.domain.Question;

import java.util.List;
import java.util.Locale;

public interface Tester {
    void setLocale(Locale locale);
    void startTesting(List<Question> questions);
}
