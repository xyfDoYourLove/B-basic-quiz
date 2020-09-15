package com.thoughtworks.gtb.basic.quiz.basic.exception;

public class UserNotExistException extends RuntimeException {

  private final String errorMessage;

  public UserNotExistException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }
}
