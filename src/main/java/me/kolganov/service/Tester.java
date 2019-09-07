package me.kolganov.service;

import me.kolganov.domain.Question;

import java.util.List;

public class Tester {
    public void startTesting(List<Question> questions) {
        Questioner questioner = new Questioner();

        System.out.println("Введите свое имя:");
        String name = questioner.askString();
        System.out.println("Введите свою фамилию:");
        String surname = questioner.askString();
        System.out.println(String.format("Поздравляю, %s %s, ты справился.", name, surname));
        System.out.println("Теперь проходи тест на знание фильма Джей и молчаливый боб наносят ответный удар");
        System.out.println();

        int counter = 0;
        for (Question q : questions) {
            System.out.println("Вопрос: ");
            System.out.println(q.getText());
            System.out.println();
            System.out.println("Варианты ответов: ");
            System.out.println(q.getAnswer1());
            System.out.println(q.getAnswer2());
            System.out.println(q.getAnswer3());
            System.out.println(q.getAnswer4());
            String answer = questioner.askNumber();

            if (answer.equals(q.getCorrectAnswer())) {
                System.out.println("Да, правильно!");
                System.out.println();
                counter++;
            } else {
                System.out.println("Ну не...");
                System.out.println();
            }
        }
        System.out.println("Твой результат: " + counter + "/" + questions.size());
    }
}
