package com.nhnent.edu.spring_mvc.exception;

import org.springframework.validation.BindingResult;

import java.util.StringJoiner;

public class ApiValidationException extends RuntimeException {
    private String message;


    public ApiValidationException(BindingResult bindingResult) {
       StringJoiner errorJoiner = new StringJoiner(" | ");
       bindingResult.getAllErrors()
                    .stream()
                    .map(error ->
                                 new StringBuilder().append("ObjectName=").append(error.getObjectName())
                                                    .append(",Message=").append(error.getDefaultMessage())
                                                    .append(",code=").append(error.getCode())

                        )
                    .forEach(errorJoiner::add);

       this.message = errorJoiner.toString();
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}