package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Questioner {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String askString() {
        String s = "";

        try {
            s = reader.readLine();

            if (!s.matches("[a-zA-Zа-яА-Я]+")) {
                System.out.println("Не вводи цифры!");
                askString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String askNumber() {
        String s = "";

        try {
            s = reader.readLine();

            if (!s.matches("[1-4]")) {
                System.out.println("Только цифры от 1 до 4");
                askNumber();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
