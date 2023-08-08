package com.example.jinnie.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.BindException;
import java.util.HashMap;
import java.util.Map;

/*
REST 방식의 컨트롤러는 에러가 발생하면 어디서 어떤 에러가 발생 했는지 알아보기가 힘들 때가 많다.
따라서 @Valid 과정에서 문제 발생시 이를 처리할 수 있도록 @RestControllerAdvice를 설계한다.
@RestControllerAdvice를 이용하면 컨트롤러에서 발생하는 예외에 대해 JSON과 같은 순수한 응답 메시지를 생성해서 보낼 수 있다.
handleBindException()은 컨트롤러에서 BindException이 던져지는 경우 이를 이용해서 JSON 메시지와 400 에러를 전송하게 한다.
 */

@RestControllerAdvice
@Log4j2
public class CustomRestAdvice {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<Map<String,String>> handleBindException(BindException e){
        log.error(e);
        Map<String, String> errorMap = new HashMap<>();
        if (e.hasErrors()) {
            BindingResult bindingResult = e.getBindingResult();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                errorMap.put(fieldError.getField(), fieldError.getCode());
            });
        }
        return ResponseEntity.badRequest().body(errorMap);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> otherException(Exception e){
        return null;
    }

}
