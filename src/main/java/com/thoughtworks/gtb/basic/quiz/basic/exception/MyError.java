package com.thoughtworks.gtb.basic.quiz.basic.exception;

import lombok.Data;

// GTB: - naming 时不要用 MyXXX 的形式，除非确实有必要
@Data
public class MyError {

  private String timestamp;

  private Integer status;

  private String error;

  private String message;
}
