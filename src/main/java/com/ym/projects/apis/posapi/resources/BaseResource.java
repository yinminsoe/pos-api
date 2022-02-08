package com.ym.projects.apis.posapi.resources;

import com.ym.projects.apis.posapi.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseResource {

    private MessageUtil messageUtil;

    public MessageUtil getMessageUtil() {
        return messageUtil;
    }

    @Autowired
    public void setMessageUtil(MessageUtil messageUtil) {
        this.messageUtil = messageUtil;
    }

}
