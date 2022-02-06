package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {
    private MessageUtil messageUtil;

    public MessageUtil getMessageUtil() {
        return messageUtil;
    }

    @Autowired
    public void setMessageUtil(MessageUtil messageUtil) {
        this.messageUtil = messageUtil;
    }

    protected String getMessage(String name, String... obj){
        return messageUtil.getPropertyByName(name, obj);
    }
}
