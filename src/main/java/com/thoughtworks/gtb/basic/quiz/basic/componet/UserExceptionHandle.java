package com.thoughtworks.gtb.basic.quiz.basic.componet;

import com.thoughtworks.gtb.basic.quiz.basic.exception.MyError;
import com.thoughtworks.gtb.basic.quiz.basic.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Date;
import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandle {

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public MyError userValidExceptionHandle(MethodArgumentNotValidException exception) {
    MyError myError = new MyError();
    myError.setMessage(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    log.error(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    myError.setTimestamp(new Date().toString());
    myError.setStatus(HttpStatus.BAD_REQUEST.value());
    myError.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
    return myError;
  }

  @ExceptionHandler(value = {UserNotExistException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public MyError userIdNotExistExceptionHandle(UserNotExistException exception) {
    MyError myError = new MyError();
    myError.setMessage(exception.getMessage());
    log.error(exception.getMessage());
    myError.setTimestamp(new Date().toString());
    myError.setStatus(HttpStatus.NOT_FOUND.value());
    myError.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
    return myError;
  }
}
