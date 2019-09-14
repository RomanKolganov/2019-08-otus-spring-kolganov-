package me.kolganov.studentTestApplication.service;

import org.springframework.core.io.Resource;

import java.util.Locale;

public interface SettingsService {
    Locale getLocale();
    Resource getResource();
}
