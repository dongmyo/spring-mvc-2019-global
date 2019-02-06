package com.nhnent.edu.spring_mvc.controlleradvice;

import com.nhnent.edu.spring_mvc.dto.ErrorMessageDto;
import com.nhnent.edu.spring_mvc.exception.ApiValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessageDto> handleNumberFormatException(NumberFormatException ex) {
        return new ResponseEntity<>(
                new ErrorMessageDto(ex.getMessage(), ex),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(ApiValidationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessageDto handleApiValidationException(ApiValidationException ex) {
        return new ErrorMessageDto(ex.getMessage(), ex);
    }

}
