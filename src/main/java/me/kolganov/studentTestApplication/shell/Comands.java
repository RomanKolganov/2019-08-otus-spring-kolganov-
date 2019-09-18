package me.kolganov.studentTestApplication.shell;

import me.kolganov.studentTestApplication.service.Tester;
import me.kolganov.studentTestApplication.utils.Constants;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class Comands {
    private Tester tester;
    private boolean isAuth;

    public Comands(Tester tester) {
        this.tester = tester;
    }

    @ShellMethod(value = "Authorization", key = {"auth", "au"})
    public void auth() {
        isAuth = tester.auth();
    }

    @ShellMethod(value = "Start testing", key = {"start-testing", "st"})
    @ShellMethodAvailability({"checkAuth"})
    public void testing() {
        tester.startTesting();
    }

    public Availability checkAuth() {
        String message = tester.notAuth();
        return isAuth ? Availability.available() : Availability.unavailable(message);
    }
}
