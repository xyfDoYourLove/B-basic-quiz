package com.thoughtworks.gtb.basic.quiz.basic.componet;

import com.thoughtworks.gtb.basic.quiz.basic.exception.MyError;
import com.thoughtworks.gtb.basic.quiz.basic.exception.ParamIllegalException;
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

  @ExceptionHandler(value = {MethodArgumentNotValidException.class, ParamIllegalException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public MyError userValidExceptionHandle(Exception exception) {
    MyError myError = new MyError();
    if (exception instanceof MethodArgumentNotValidException) {
      myError.setMessage(Objects.requireNonNull(((MethodArgumentNotValidException) exception).getBindingResult().getFieldError()).getDefaultMessage());
      log.error(Objects.requireNonNull(((MethodArgumentNotValidException) exception).getBindingResult().getFieldError()).getDefaultMessage());
    }else {
      myError.setMessage(exception.getMessage());
      log.error(exception.getMessage());
    }
    myError.setTimestamp(new Date().toString());
    myError.setStatus(HttpStatus.BAD_REQUEST.value());
    myError.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
    return myError;
  }

}
