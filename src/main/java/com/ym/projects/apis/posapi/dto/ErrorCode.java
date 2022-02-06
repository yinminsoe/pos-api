package com.ym.projects.apis.posapi.dto;


public enum ErrorCode {
    CE0001("Resource Not Found Exception"),
    SE0001("Server Exception");

    private String errorDescription;

    private ErrorCode(String errorDescription){
        this.errorDescription   = errorDescription;
    }



    public String getErrorDescription() {
        return errorDescription;
    }
}
