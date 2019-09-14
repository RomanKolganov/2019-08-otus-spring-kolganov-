package me.kolganov.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class LocalizationServiceImpl implements LocalizationService {
    private MessageSource messageSource;
    private SettingsService settingsService;

    public LocalizationServiceImpl(MessageSource messageSource, SettingsService settingsService) {
        this.messageSource = messageSource;
        this.settingsService = settingsService;
    }

    @Override
    public String getMessage(String key) {
        return messageSource.getMessage(key, null, settingsService.getLocale());
    }
}
