package me.kolganov.studentTestApplication.service;

import me.kolganov.studentTestApplication.config.Settings;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class LocalizationServiceImpl implements LocalizationService {
    private MessageSource messageSource;
    private Settings settings;

    public LocalizationServiceImpl(MessageSource messageSource, Settings settings) {
        this.messageSource = messageSource;
        this.settings = settings;
    }

    @Override
    public String getMessage(String key) {
        return messageSource.getMessage(key, null, settings.getLocale());
    }
}
