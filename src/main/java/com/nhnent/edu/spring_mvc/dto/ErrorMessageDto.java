package com.nhnent.edu.spring_mvc.dto;

public class ErrorMessageDto {
    private final String message;
    private final String className;


    public ErrorMessageDto(String message, Exception e) {
        this.message = message;
        this.className = e.getClass().getCanonicalName();
    }


    public String getMessage() {
        return message;
    }

    public String getClassName() {
        return className;
    }

}
