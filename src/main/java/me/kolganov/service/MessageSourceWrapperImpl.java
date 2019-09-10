package me.kolganov.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageSourceWrapperImpl implements MessageSourceWrapper {
    private MessageSource messageSource;
    @Value("${locale}")
    private Locale locale;

    public MessageSourceWrapperImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String key) {
        return messageSource.getMessage(key, null, locale);
    }
}
