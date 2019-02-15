package com.nhnent.edu.spring_mvc.controlleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {
    // TODO : #2 NumberFormatException 을 처리하는 exception handler method를 작성하세요.
    //        http status: 500 internal server error
    //        response body: ErrorMessageDto 활용
    //        cf.) new ErrorMessageDto(ex.getMessage(), e)
	// TODO : #2 write a exception handler method which handles a NumberFortmatException.
	//        http status: 500 internal server error
	//        use response body: ErrorMessageDto   
	//  cf.) new ErrorMessageDto(ex.getMessage(), e)
	
	// ???

}
