package me.kolganov.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class SettingsServiceImpl implements SettingsService {
    @Value("${locale}")
    private Locale locale;

    @Value("${" + "${file}" + "${locale}" + "}")
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
