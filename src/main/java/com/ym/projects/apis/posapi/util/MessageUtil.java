package com.ym.projects.apis.posapi.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

    private final MessageSource messageSource;

    public MessageUtil(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getProperty(String name){
        return messageSource.getMessage(name, null, LocaleContextHolder.getLocale());
    }

    public String getPropertyWithPlaceHolder(String name, Object[] objs){
       return messageSource.getMessage(name, objs, LocaleContextHolder.getLocale());
    }
}
