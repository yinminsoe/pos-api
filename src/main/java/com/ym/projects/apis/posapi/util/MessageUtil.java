package com.ym.projects.apis.posapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class MessageUtil {

    @Autowired
    private Environment env;

    public String getPropertyByName(String name, String... obj){
       return MessageFormat.format(env.getProperty(name), obj);
    }
}
