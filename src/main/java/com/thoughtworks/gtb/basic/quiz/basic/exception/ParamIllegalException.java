package com.thoughtworks.gtb.basic.quiz.basic.exception;

public class ParamIllegalException extends RuntimeException {

  private final String errorMessage;

  public ParamIllegalException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }
}
