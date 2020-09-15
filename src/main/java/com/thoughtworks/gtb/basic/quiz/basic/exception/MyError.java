package com.thoughtworks.gtb.basic.quiz.basic.exception;

import lombok.Data;

@Data
public class MyError {

  private String timestamp;

  private Integer status;

  private String error;

  private String message;
}
