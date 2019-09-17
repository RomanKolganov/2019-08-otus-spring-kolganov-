package me.kolganov.studentTestApplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Component
@PropertySource("classpath:application.yml")
public class Settings {
    @Value("${locale}")
    private Locale locale;

    @Value("${" + "${file_name}" + "${locale}" + "}")
    private Resource resource;

    public Locale getLocale() {
        return locale;
    }

    public Resource getResource() {
        return resource;
    }
}
