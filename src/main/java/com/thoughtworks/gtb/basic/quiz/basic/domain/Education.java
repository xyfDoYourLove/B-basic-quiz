package com.thoughtworks.gtb.basic.quiz.basic.domain;

import com.thoughtworks.gtb.basic.quiz.basic.common.ExceptionMessageConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education {

  private long userId;

  @NotNull(message = ExceptionMessageConstant.YEAR_IS_REQUIRED)
  private long year;

  @NotBlank(message = ExceptionMessageConstant.TITLE_IS_REQUIRED)
  @Size(max = 256, min = 1, message = ExceptionMessageConstant.TITLE_LENGTH_IS_ILLEGAL)
  private String title;

  @NotBlank(message = ExceptionMessageConstant.ED_DESCRIPTION_ID_REQUIRED)
  @Size(max = 4096, min = 1, message = ExceptionMessageConstant.ED_DESCRIPTION_LENGTH_IS_ILLEGAL)
  private String description;

}
