package me.kolganov.studentTestApplication.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@PropertySource("classpath:application.yml")
public class SettingsServiceImpl implements SettingsService {
    @Value("${locale}")
    private Locale locale;

    @Value("${" + "${file_name}" + "${locale}" + "}")
    private Resource resource;

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public Resource getResource() {
        return resource;
    }
}
