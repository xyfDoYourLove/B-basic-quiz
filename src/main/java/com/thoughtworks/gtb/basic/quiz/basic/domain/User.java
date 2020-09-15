package com.thoughtworks.gtb.basic.quiz.basic.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thoughtworks.gtb.basic.quiz.basic.common.ExceptionMessageConstant;
import com.thoughtworks.gtb.basic.quiz.basic.serialize.DescriptionSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private long id;

  @NotBlank(message = ExceptionMessageConstant.USERNAME_IS_REQUIRED)
  @Size(max = 128, min = 1, message = ExceptionMessageConstant.USERNAME_LENGTH_IS_ILLEGAL)
  private String name;

  @NotNull(message = ExceptionMessageConstant.AGE_IS_REQUIRED)
  @Min(value = 17, message = ExceptionMessageConstant.AGE_IS_TOO_SMALL)
  private long age;

  @NotBlank(message = ExceptionMessageConstant.AVATAR_IS_REQUIRED)
  @Size(max = 512, min = 8, message = ExceptionMessageConstant.AVATAR_LENGTH_IS_ILLEGAL)
  private String avatar;

  @Size(max = 512, min = 8, message = ExceptionMessageConstant.DESCRIPTION_LENGTH_IS_ILLEGAL)
  @JsonSerialize(nullsUsing = DescriptionSerializer.class)
  private String description;

}
