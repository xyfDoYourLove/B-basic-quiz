package com.thoughtworks.gtb.basic.quiz.basic.domain;

import com.thoughtworks.gtb.basic.quiz.basic.common.ExceptionMessageConstant;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class User {

  private long id;

  @NotBlank(message = ExceptionMessageConstant.USERNAME_IS_REQUIRED)
  @Size(max = 64, min = 1, message = ExceptionMessageConstant.USERNAME_LENGTH_IS_ILLEGAL)
  private String name;

  @NotBlank(message = ExceptionMessageConstant.AGE_IS_REQUIRED)
  @Min(value = 17, message = ExceptionMessageConstant.AGE_IS_TOO_SMALL)
  private long age;

  @NotBlank(message = ExceptionMessageConstant.AVATAR_IS_REQUIRED)
  @Size(max = 512, min = 8, message = ExceptionMessageConstant.AVATAR_LENGTH_IS_ILLEGAL)
  private String avatar;

  @Size(max = 512, min = 8, message = ExceptionMessageConstant.DESCRIPTION_LENGTH_IS_ILLEGAL)
  private String description;

}
