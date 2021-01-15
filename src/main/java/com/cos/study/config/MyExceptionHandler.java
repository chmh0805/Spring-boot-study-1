package com.cos.study.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// Exception을 낚아채기
@RestController
@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public String badReuqestException(Exception e) {
		return "요청을 잘못하셨습니다.. 상태코드 : "+HttpStatus.BAD_REQUEST.value();
	}
}
