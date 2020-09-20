package com.thoughtworks.gtb.basic.quiz.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "educations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

  @Id
  @GeneratedValue
  private long id;

  private long year;

  private String title;

  private String description;

  @ManyToOne
  private UserDto user;

}
